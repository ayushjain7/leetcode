//https://leetcode.com/problems/bitwise-and-of-numbers-range/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0 || n==0)
            return 0;
        int copyM = m;
        int copyN = n;
        int highestChangeBit = 0;
        
        for(int i=0; i<32; i++){
            if(copyM%2 != copyN%2){
                highestChangeBit = i+1;
            }
            copyM = copyM >> 1;
            copyN = copyN >> 1;
        }
        copyM = m;
        copyN = n;
        copyM = copyM >> highestChangeBit;
        copyN= copyN >> highestChangeBit;
        int result = copyM&copyN;
        result = result << highestChangeBit;
        return result;
    }
}
