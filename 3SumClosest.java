public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int minSum = Integer.MAX_VALUE - target;
        for(int i=0; i<size-1; i++){
            for(int j=i+1, k=size-1; j<k;){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - sum) < Math.abs(target - minSum))
                    minSum = sum;
                if(sum > target)
                    k--;
                else
                    j++;
            }
        }
        return minSum;
    }
}
