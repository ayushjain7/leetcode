// https://leetcode.com/problems/container-with-most-water/

import static java.lang.Math.abs;

public class Solution {
    public int maxArea(int[] height) {
        int area = 0, lower = 0, higher = height.length-1;
        while(higher != lower){
            if(height[lower] > height[higher]){
                int temp = lower;
                lower = higher;
                higher = temp;
            }
            if (area < abs(higher-lower)*height[lower])
                area = abs(higher-lower)*height[lower];
            lower = lower < higher ? lower + 1 : lower - 1;
        }
        return area;
    }
}
