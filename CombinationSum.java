//https://leetcode.com/problems/combination-sum/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null)
            return null;
        Arrays.sort(candidates);
        return formSets(candidates, new ArrayList<>(), target, 0);
    }

    private static List<List<Integer>> formSets(int[] candidates, List<Integer> comb, int target, int start) {
        if(target == 0)
            return Collections.singletonList(comb);
        List<List<Integer>> result = new ArrayList<>();
        if(target<candidates[0]) {
            return result;
        }
        for(int i=start; i<candidates.length; i++){
            List<Integer> temp = new ArrayList<>(comb);
            temp.add(candidates[i]);
            List<List<Integer>> response = formSets(candidates, temp, target-candidates[i], i);
            if(!response.isEmpty())
                result.addAll(response);
        }
        return result;
    }}
