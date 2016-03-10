//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int size = prices.length;
        int sell[] = new int[size];
        int cool[] = new int[size];
        sell[0] = 0; cool[0] = 0;
        for(int i =1; i<size; i++){
            sell[i] = Math.max(sell[i-1] + prices[i] - prices[i-1], cool[i-1]);
            cool[i] = Math.max(sell[i-1], cool[i-1]);
        }
        return Math.max(sell[size-1], cool[size-1]);
    }
}
