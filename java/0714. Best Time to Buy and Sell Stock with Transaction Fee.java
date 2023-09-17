// LeetCode 75 DP - Multidimensional Q3
// 08/24/2023 Impl
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dpHold = -prices[0], dpNone = 0;
        for (int i = 1; i < n; i++) {
            int l = dpHold;
            int m = l + prices[i] - fee;
            int k = dpNone - prices[i];
            dpHold = Math.max(l, k);
            dpNone = Math.max(m, dpNone);
        }
        return dpNone;
    }
}

// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int dpHold;
//         int dpNone;
//         int n = prices.length;

//         dpHold = -prices[0];
//         dpNone = 0;
//         for (int i = 1; i < n; i++) {
//             int l;
//             int r;
            
//             l = dpNone;
//             r = dpHold + prices[i] - fee;
//             dpNone = l > r ? l : r;

//             l = dpHold;
//             r = dpNone - prices[i];
//             dpHold = l > r ? l : r;
            
//         }
//         return dpNone;
//     }
// }

/*
    dp[i] max profit @price[i]
    two situations:
    dp[i][0] no stock @price[i]
    dp[i][1] hold stock @i

    k = 0 ~ i-1
    dp[i][0] = max{
        dp[k][0];   //stock as k point
        // simplyfy it to dp[i - 1][0]

        dp[k][1] + p[i] - fee; // sell stock @i
    }

    dp[i][1] = max{
        dp[k][1]; // hold stock as i-1 point
        // simplyfy it to dp[i-1][1]

        dp[i - 1][0] - p[i]; // no stock before i and buy @i;
    }
 */
