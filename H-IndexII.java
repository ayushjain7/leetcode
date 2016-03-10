// https://leetcode.com/problems/h-index-ii/

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        int size=citations.length;
        int i = size-1;
        while(i>=0 && citations[i]>=size-i){
            i--;
        }
        return size-i-1;
    }
}
