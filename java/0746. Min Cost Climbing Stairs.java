// LeetCode 75 DP - 1D Q2
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        int n = cost.length;
        for (int i = 2; i <=n; i++) {
            int c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }
        return b;
    }
}

// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int[] dp = new int[3];
//         int n = cost.length;
//         dp[0] = 0;
//         dp[1] = 0;
//         for (int i = 2; i <= n; i++) {
//             int i0 = i % 3;
//             int i1 = (i - 1) % 3;
//             int i2 = (i - 2) % 3;
//             dp[i0] = Math.min(dp[i1] + cost[i - 1], dp[i2] + cost[i - 2]);
//         }
//         return dp[n % 3];
//     }
// }
