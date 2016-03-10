// https://leetcode.com/problems/gray-code/

import static java.lang.Math.pow;

public class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 0 )
            return Collections.singletonList(0);
        int size = (int)pow(2, n);
        List<Integer> codes = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            int code = i&(size/2);
            for(int j=n-2; j>=0; j--){
                code = code | ((i & ((int)pow(2,j)))^((i & ((int)(pow(2,j+1))))>>1));
            }
            codes.add(code);
        }
        return codes;
    }
}
