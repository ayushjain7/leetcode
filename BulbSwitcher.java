//https://leetcode.com/problems/bulb-switcher/

public class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for(int i=1; i<=Math.sqrt(n); i++){
            count++;
        }
        return count;
    }
}
