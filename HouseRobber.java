// https://leetcode.com/problems/house-robber/

public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        int size = nums.length;
        int[] rob = new int[size];
        int[] skip = new int[size];
        rob[0] = nums[0];
        for(int i=1; i<size; i++){
            rob[i] = Math.max(rob[i-1], skip[i-1]+nums[i]);
            skip[i] = Math.max(skip[i-1], rob[i-1]);
        }
        return Math.max(rob[size-1], skip[size-1]);
    }
}
