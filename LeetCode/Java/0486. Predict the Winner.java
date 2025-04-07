// Daily Challenge 07/28/2023
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        // dp[i][j] = nums[j] - dp[i][j - 1]
        //          or nums[i] - dp[i + 1][j]
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(
                    nums[j] - dp[j - 1],
                    nums[i] - dp[j]
                );
            }
        }
        return dp[n - 1] >= 0;
    }
}
// 想象一下阶梯型的dp, 可以发现，用y更新只用x,以此类推
// 为了不覆盖，可以从右下到左上更新
/**
 * This is a 2D array:
 *    j=  0   1
 *      +---+---+---+---+---+
 * i=0  | x | y |   |   |   |
 *      +---+---+---+---+---+
 *   1  |   | x | y |   |   |
 *      +---+---+---+---+---+
 *      |   |   | x | y |   |
 *      +---+---+---+---+---+
 *      |   |   |   | x | y |
 *      +---+---+---+---+---+
 *      |   |   |   |   | x |
 *      +---+---+---+---+---+
 */
// just cosider the diff after each pick,
// A pick l, diff + l, B pick k, diff - l

// naive dp
// class Solution {
//     int[][] dp;
//     boolean[][] visited;
//     private int dfs(int[] nums, int l, int r) {
//         if (visited[l][r]) {
//             return dp[l][r];
//         }
//         int left = nums[l] - dfs(nums, l + 1, r);
//         int right = nums[r] - dfs(nums, l, r - 1);
//         return Math.max(left, right);
//     }
//     public boolean PredictTheWinner(int[] nums) {
//         int n = nums.length;
//         dp = new int[n][n];
//         visited = new boolean[n][n];
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = nums[i];
//             visited[i][i] = true;
//         }
//         return dfs(nums, 0, n - 1) >= 0;
//     }
// }
