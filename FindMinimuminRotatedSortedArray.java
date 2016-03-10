// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class Solution {
    public int findMin(int[] nums) {
        if(nums==null)
            return 0;
        int i=1;
        while(i<nums.length && nums[i]>nums[i-1]){
            i++;
        }
        return (i == nums.length) ? nums[0] : nums[i];
    }
}
