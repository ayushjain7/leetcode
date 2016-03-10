// https://leetcode.com/problems/house-robber-ii/

public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        int size = nums.length;
        if(size == 1)
            return nums[0];
        if(size == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, size-2), rob(nums, 1, size-1));
    }
    
    public int rob(int[] nums, int start, int end){
        int[] rob = new int[end-start+1];
        int[] skip = new int[end-start+1];
        
        rob[0] = nums[start];
        skip[0] = 0;
        for(int i=1; i<=end-start; i++){
            rob[i] = Math.max(rob[i-1], skip[i-1]+nums[i+start]);
            skip[i] = Math.max(skip[i-1], rob[i-1]);
        }
        return Math.max(rob[end-start], skip[end-start]);
    }
}
