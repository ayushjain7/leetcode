//https://leetcode.com/problems/maximum-subarray/

public class Solution {
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, preSum = Integer.MIN_VALUE;
        for(int num : nums){
            preSum = preSum > 0 ? preSum+num : num;
            if(preSum > max)
                max = preSum;
        }
        return max;
    }
}
