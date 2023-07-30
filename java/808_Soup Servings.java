// Daily Challenge 07/29/2023
class Solution {
    static final int[][] DIR = new int[][] {
        {-4, 0}, {-3, -1}, {-2, -2}, {-1, -3}
    };
    static double[][] dp = new double[201][201];
    // static {
    //     for (double[] d : dp) {
    //         Arrays.fill(d, -1.0);
    //     }
    // }
    // double[][] dp;
    private double dfs(int a, int b) {
        if (a <= 0 & b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if (dp[a][b] > 0) {
            return dp[a][b];
        }
        dp[a][b] = 0.0;
        for (int[] d : DIR) {
            dp[a][b] += 0.25 * dfs(a + d[0], b + d[1]);
        }
        // dp[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b -3));
        return dp[a][b];
    }
    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        int k = (n + 24) / 25;
        // dp = new double[k + 1][k + 1];
        return dfs(k, k);
    }
}
