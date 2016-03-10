// https://leetcode.com/problems/longest-increasing-subsequence/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (nums == null || size ==0)
            return 0;
        int[] res = new int[size];
        Arrays.fill(res, 1);
        for(int i=0; i< size; i++){
            for(int j=0; j< i; j++){
                if(nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int max =0;
        for(int i=0; i< size; i++){
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
