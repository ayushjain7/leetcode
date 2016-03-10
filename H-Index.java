//https://leetcode.com/problems/h-index/

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        int[] sortedCitations = citations.clone();
        Arrays.sort(sortedCitations);

        int size=sortedCitations.length;
        int i = size-1;
        while(i>=0 && sortedCitations[i]>=size-i){
            i--;
        }
        return size-i-1;
    }
}
