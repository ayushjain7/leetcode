//https://leetcode.com/problems/generate-parentheses/

public class Solution {
    public static List<String> generateParenthesis(int n) {
        if(n<=0)
            return null;
        return generatePattern(n, 1, 1, "(");

    }

    private static List<String> generatePattern(int n, int status, int i, String pattern){
        if(i==2*n){
            List<String> patterns = new ArrayList<String>();
            patterns.add(pattern);
            return patterns;
        }
        if( status == 0){
            return generatePattern(n, status+1, i+1, pattern + "(");
        }else if (status == 2*n-i){
            return generatePattern(n, status-1, i+1, pattern + ")");
        }else{
            List<String> patterns = new ArrayList<String>();
            patterns.addAll(generatePattern(n, status+1, i+1, pattern + "("));
            patterns.addAll(generatePattern(n, status-1, i+1, pattern + ")"));
            return patterns;
        }
    }
}
