// LeetCode 75 DP - 1D Q1
class Solution {
    public int tribonacci(int n) {
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        return c;
    }
}

// class Solution {
//     public int tribonacci(int n) {
//         int[] dp = new int[3];
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 1;
//         for (int i = 3; i <= n; i++) {
//             int i0 = i % 3;
//             int i1 = (i - 1) % 3;
//             int i2 = (i - 2) % 3;
//             dp[i0] += dp[i1] + dp[i2];
//         }
//         return dp[n % 3];
//     }
// }
