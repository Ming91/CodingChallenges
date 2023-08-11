// Daily Challenge 08/11/2023
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
// 挨个硬币来看, [0, amount]用每个数字i更新i+coin的值
// 想法没错, 写的太蠢. 缺少训练
// 更一般的, 应该先想二维的想法dp[i][j]表示前i个coin和为j的组合数
// dp[i][j] = dp[i][j - coin[i]] + dp[i - 1][j]
