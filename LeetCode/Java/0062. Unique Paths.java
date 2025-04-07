// Daily Question 09/03/2023
// LeetCode 75 DP - Multidimensional Q1
class Solution {
    public int uniquePaths(int m, int n) {
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1L;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = 1L;
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
                dp[j] = dp[j];
            }
        }
        return (int)dp[n - 1];
    }
}
// combinatorial problem:
//  h horizontal moves, v vertical moves,
//  total (h + v) moves, choose h (or v) in h + v
//  C(h + v, h) = (h + v)! / v! / h!
// tips: best factorial algo can be O(n (log n)^~3), 
//  using rearrange the factorial to prime powers
