// LeetCode 75 DP - Multidimensional Q4
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] ch1 = word1.toCharArray(), ch2 = word2.toCharArray();
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            
            int prev = i - 1;
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = prev;
                prev = dp[j];
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[j] = temp;
                } else {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), temp) + 1;
                }
            }
        }
        return dp[n];
    }
}

// class Solution {
    
//     public int minDistance(String word1, String word2) {
//         int m = word1.length(), n = word2.length();
//         // if (m == 0) {
//         //     return n;
//         // }
//         // if (n == 0) {
//         //     return m;
//         // }
//         int[][] dp = new int[m + 1][n + 1];
//         for (int j = 1; j <= n; j++) {
//             dp[0][j] = j;
//         }
//         for (int i = 1; i <= m; i++) {
//             dp[i][0] = i;
//             for (int j = 1; j <= n; j++) {
//                 if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
//  d = min(x, y, z) + 1. if same char, d = x
//  wrong table below, should transpose i and j
//      |0  |...| i-1 |  i
//  0   |   |   | i-1 |  i
//  ... |   |   |     |
//  j-1 |   |   |  x  |  z
//  j   | j |   |  y  |  d
