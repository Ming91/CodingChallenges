// Top Interview 150 Array / String Q7
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for (int price : prices) {
            profit = Math.max(profit, price - buy);
            buy = Math.min(buy, price);
        }
        return profit;
    }
}
