// LeetCode 75 DP - Multidimensional Q2
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                int prev = temp;
                temp = dp[j];
                if (text1.charAt(i) == text2.charAt(j - 1)) {
                    // cant get from dp[i - 1][j] or dp[i][j - 1]
                    //  eg. bob and ccb, 
                    //  use formula above will match b in text2 with both b in text1
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[n];
    }
}

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length(), n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     // cant get from dp[i - 1][j] or dp[i][j - 1]
//                     //  eg. bob and ccb, 
//                     //  use formula above will match b in text2 with both b in text1
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
