// https://leetcode.com/problems/jump-game/

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null)
            return false;
        int size = nums.length;
        boolean[] canJump = new boolean[size];
        canJump[size-1] = true;
        for(int i=size-2; i>=0; i--){
            if(nums[i] == 0){
                int skipIndexes = 1;
                while(skipIndexes > nums[i]){
                    skipIndexes++;
                    i--;
                    if(i<0) return false;
                }
            }
        }
        return true;
    }
}
