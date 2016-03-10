// https://leetcode.com/problems/combinations/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combinations(n, k, new ArrayList<>());
    }

    public List<List<Integer>> combinations(int n, int k, List<Integer> comb){
        if (comb.size() == k) {
            return Collections.singletonList(comb);
        }
        List<List<Integer>> toRet = new ArrayList<>();
        int i = comb.size() == 0 ? 1 : comb.get(comb.size()-1)+1;
        while(i<=n && n-i>=k-comb.size()-1) {
            List<Integer> temp = new ArrayList<>(comb);
            temp.add(i);
            toRet.addAll(combinations(n, k, temp));
            i++;
        }
        return toRet;
    }
}
