// LeetCode 75 DP - 1D Q3
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int a = 0, b = nums[0];
        for (int i = 2; i <= n; i++) {
            int res = Math.max(a + nums[i - 1], b);
            a = b;
            b = res;
        }
        return b;
    }
}

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) {
//             return nums[0];
//         }
//         int[] dp = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = nums[0];
//         for (int i = 2; i <= n; i++) {
//             dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//         }
//         return dp[n];
//     }
// }
