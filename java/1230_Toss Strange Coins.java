class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[] dp = new double[target + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i ++) {
            // target to 1, since use dp[j-1] from previou to update dp[j]
            for (int j = target; j >= 1; j--) {
                dp[j] = dp[j] * (1 - prob[i]) + dp[j - 1] * prob[i];
            }
            dp[0] = dp[0] * (1 - prob[i]); 
        }
        return dp[target];
    }
}
//1-d array dp, use dp[j-1] update dp[j[
