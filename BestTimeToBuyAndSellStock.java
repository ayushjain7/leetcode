//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0)
            return 0;
        int n = prices.length;
        int max = prices[n-1];
        int[] maxProfit = new int[n];
        maxProfit[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            max = max > prices[i] ? max : prices[i];
            maxProfit[i] = max - prices[i] > maxProfit[i+1] ? max - prices[i] : maxProfit[i+1];
        }
        return maxProfit[0];
    }
}
