//https://leetcode.com/problems/combination-sum-iii/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinations(n, k, new ArrayList<>());
    }

    public List<List<Integer>> combinations(int n, int k, List<Integer> comb){
        if (k == comb.size()){
            if(n==0) {
                return Collections.singletonList(comb);
            }else{
                return new ArrayList<>();
            }
        }
        List<List<Integer>> toRet = new ArrayList<>();
        int i = comb.size() == 0 ? 1 : comb.get(comb.size()-1)+1;
        while(i<=9 && i<=n) {
            List<Integer> temp = new ArrayList<>(comb);
            temp.add(i);
            toRet.addAll(combinations(n-i, k, temp));
            i++;
        }
        return toRet;
    }
}
