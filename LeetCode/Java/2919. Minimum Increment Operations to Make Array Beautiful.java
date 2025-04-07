// Weekly Contest 369 Q3
class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        long dp1 = 0, dp2 = 0, dp3 = 0;
        long dp = 0;
        for (int num : nums) {
            dp = Math.min(dp1, Math.min(dp2, dp3)) + Math.max(k - num, 0);
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp;
        }
        return Math.min(dp1, Math.min(dp2, dp3));
    }
}
// [Lee]
//  O(1) space, use dp as the cost to make curr valid. 
//  dp1 = dp[i-3], dp2 = dp[i-2], dp3 = dp[i-1]
//  Explaination: in i-3, i-2, i-1, we only need at most one to be valid. 
// [Ming]
//  Not so smart dp solution. 
// class Solution {
//     int getCost(int x, int k) {
//         return x >= k ? 0 : k - x;
//     }
//     public long minIncrementOperations(int[] nums, int k) {
//         int n = nums.length;
//         long[][] dp = new long[n][2];
//         dp[n - 1][0] = getCost(nums[n - 1], k);
//         dp[n - 1][1] = dp[n - 1][0];
//         for (int i = n - 2; i >= 0; i--) {
//             long min = Long.MAX_VALUE;
//             dp[i][1] = getCost(nums[i], k);
//             if (i < n - 3) {
//                 dp[i][1] += dp[i + 1][0];
//             }
//             for (int j = i + 1; j < i + 3 && j < n; j++) {
//                 min = Math.min(min, dp[j][1]);
//             }
//             dp[i][0] = Math.min(min, dp[i][1]);
//         }
//         return dp[0][0];
//     }
// }
