// Weekly Contest 359 Q3
class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> {
            if (a.get(1) == b.get(1)) {
                return b.get(2) - a.get(2);
            } 
            return a.get(1) - b.get(1);
        });
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (idx < offers.size() && offers.get(idx).get(1) <= i - 1) {
                int prev = offers.get(idx).get(0);
                int price = offers.get(idx).get(2);
                dp[i] = Math.max(dp[i], dp[prev] + price);
                idx++;
            }
        }
        return dp[n];
                         
    }
}
