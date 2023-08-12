// Daily Challenge 08/11/2023
class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length;
        int n = ob[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int ii = 0; ii < m ; ii++) {
            if (ob[ii][0] == 1) {
                dp[0] = 0;
            }
            for (int i = 1; i < n; i++) {
                if (ob[ii][i] == 1) {
                    dp[i] = 0;
                } else {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
// 入门dp
