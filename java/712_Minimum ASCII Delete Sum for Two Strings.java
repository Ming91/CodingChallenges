// Daily Challenge 07/31/2023
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = ch2[i - 1] + dp[i - 1];
        }
        for (int i = 1; i <= m; i++) {
            int diag = dp[0];
            dp[0] += ch1[i - 1];
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[j] = diag;
                } else {
                    dp[j] = Math.min(dp[j - 1] + ch2[j - 1], dp[j] + ch1[i - 1]);
                }
                diag = temp;
            }
        }
        return dp[n];
    }
}



// 经典2d->1d,
// 把i-1,j-1的值在更新i,j-1时存一下,就行了
// +------+-------+------+------+------+
// |      |       |      |      |      |
// +------+-------+------+------+------+
// |      |i-1,j-1| i-1,j|      |      |
// +------+-------+------+------+------+
// |      |i,j-1  | i,j  |      |      |
// +------+-------+------+------+------+
// |      |       |      |      |      |
// +------+-------+------+------+------+

// dp, s1[i]和s2[j]相等,则从[i - 1][j - 1]继承
// 否则,从[i][j - 1] + [j] 和[i - 1][j] + [i]选
// class Solution {
//     public int minimumDeleteSum(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
//         char[] ch1 = s1.toCharArray();
//         char[] ch2 = s2.toCharArray();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i <= m; i++) {
//             // dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
//             dp[i][0] = ch1[i - 1] + dp[i - 1][0];
//         }
//         for (int i = 1; i <= n; i++) {
//             // dp[0][i] = s2.charAt(i - 1) + dp[0][i - 1];
//             dp[0][i] = ch2[i - 1] + dp[0][i - 1];
//         }
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 char c1 = ch1[i - 1];
//                 char c2 = ch2[j - 1];
//                 if (c1 == c2) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c2);
//                                         // Math.min(dp[i][j - 1] + c2, 
//                                         //          dp[i - 1][j - 1] + c1 + c2));
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
