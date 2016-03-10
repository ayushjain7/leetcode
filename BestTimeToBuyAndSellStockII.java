//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, i=0;
        boolean bought = false;
        if(prices == null){
            return 0;
        }
        for(; i<prices.length-1; i++){
            if(bought){
                if(prices[i] > prices[i+1]){
                    bought = false;
                    maxProfit += prices[i];
                }
            }
            else{
                if(prices[i] < prices[i+1]){
                    bought = true;
                    maxProfit -= prices[i];
                }
            }
        }
        if(bought){
            bought = false;
            maxProfit += prices[i];
        }
        return maxProfit;
    }
}
