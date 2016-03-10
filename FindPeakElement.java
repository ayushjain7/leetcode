// https://leetcode.com/problems/find-peak-element/

public class Solution {
    public int findPeakElement(int[] nums) {
        int i=1, n = nums.length;
        while (i < n && nums[i] > nums[i - 1])
            i++;
        return i-1;
    }
}
