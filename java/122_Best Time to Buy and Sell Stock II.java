// Top Interview 150 Array / String Q8
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for (int price : prices) {
            if (price > buy) {
                profit += price - buy;
            }
            buy = price;
        }
        return profit;
    }
}
