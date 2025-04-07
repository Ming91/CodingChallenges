// Daily Question 10/07/2023
class Solution {
    static final int MOD = 1_000_000_007;
    int m, n, k;
    public int numOfArrays(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        long[][] dp = new long[m + 1][k + 1];
        for (int maxSoFar = 1; maxSoFar <= m; maxSoFar++) {
            dp[maxSoFar][0] = 1;
        }
        for (int index = n - 1; index >= 0; index--) {
            for (int remain = k; remain >= 0; remain--) {
                long sum = 0;
                for (int maxSoFar = m; maxSoFar >= 0; maxSoFar--) {
                    long ans = (maxSoFar * dp[maxSoFar][remain] + sum) % MOD;
                    sum += remain > 0 ? dp[maxSoFar][remain - 1] : 0;
                    dp[maxSoFar][remain] = ans;
                }
            }
        }
        return (int)dp[0][k];
    }
}
// [Beat 99%]
//  no duplicate array, just use sum += dp[i][j - 1];

// [Editorial] dp with 2D array. 
//  Draw a table can easily solve this structure. 
//  dp[i][j] = dp[i][j] * i + sum(dp[i + 1 ~ m][j - 1])

// class Solution {
//     static final int MOD = 1_000_000_007;
//     int m, n, k;
//     public int numOfArrays(int n, int m, int k) {
//         this.n = n;
//         this.m = m;
//         this.k = k;
//         long[][] dp = new long[m + 1][k + 1];
//         long[][] prefix = new long[m + 1][k + 1];
//         for (int maxSoFar = 1; maxSoFar <= m; maxSoFar++) {
//             dp[maxSoFar][0] = 1;
//             prefix[maxSoFar][0] = m - maxSoFar + 1;
//         }
//         for (int index = n - 1; index >= 0; index--) {
//             for (int remain = k; remain >= 0; remain--) {
//                 for (int maxSoFar = m; maxSoFar >= 0; maxSoFar--) {
//                     long ans = (maxSoFar * dp[maxSoFar][remain]) % MOD;
//                     if (remain > 0 && maxSoFar < m) {
//                         ans = (ans + prefix[maxSoFar + 1][remain - 1]) % MOD;
//                     }
//                     dp[maxSoFar][remain] = ans;
//                     prefix[maxSoFar][remain] = maxSoFar == m ? ans : (ans + prefix[maxSoFar + 1][remain]) % MOD;
//                 }
//             }
//         }
//         return (int)dp[0][k];
//     }
// }

// [Editorial] Iteration DP.
// class Solution {
//     static final int MOD = 1_000_000_007;
//     int m, n, k;
//     public int numOfArrays(int n, int m, int k) {
//         this.n = n;
//         this.m = m;
//         this.k = k;
//         int[][][] dp = new int[n + 1][m + 1][k + 1];
//         for (int maxSoFar = 1; maxSoFar <= m; maxSoFar++) {
//             dp[n][maxSoFar][0] = 1;
//         }
//         for (int index = n - 1; index >= 0; index--) {
//             for (int maxSoFar = 0; maxSoFar <= m; maxSoFar++) {
//                 for (int remain = 0; remain <= k; remain++) {
//                     int ans = 0;
//                     for (int i = 1; i <= maxSoFar; i++) {
//                         ans = (ans + dp[index + 1][maxSoFar][remain]) % MOD;
//                     }
//                     if (remain >= 1) {
//                         for (int i = maxSoFar + 1; i <= m; i++) {
//                             ans = (ans + dp[index + 1][i][remain - 1]) % MOD;
//                         }
//                     }
//                     dp[index][maxSoFar][remain] = ans;
//                 }
//             }
//         }
//         return dp[0][0][k];
//     }
// }

// [Editorial] recursion dp. 
// class Solution {
//     static final int MOD = 1_000_000_007;
//     int m, n, k;
//     int calc(Integer[][][] dp, int index, int maxSoFar, int remain) {
//         if (index == n) {
//             return remain == 0 ? 1 : 0;
//         }
//         if (remain < 0) {
//             return 0;
//         }
//         if (dp[index][maxSoFar][remain] != null) {
//             return dp[index][maxSoFar][remain];
//         }
//         int ans = 0;
//         for (int i = 1; i <= maxSoFar; i++) {
//             ans = (ans + calc(dp, index + 1, maxSoFar, remain)) % MOD;
//         }
//         for (int i = maxSoFar + 1; i <= m; i++) {
//             ans = (ans + calc(dp, index + 1, i, remain - 1)) % MOD;
//         }
//         dp[index][maxSoFar][remain] = ans;
//         return ans;
//     }
//     public int numOfArrays(int n, int m, int k) {
//         this.n = n;
//         this.m = m;
//         this.k = k;
//         Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
//         return calc(dp, 0, 0, k);
//     }
// }
