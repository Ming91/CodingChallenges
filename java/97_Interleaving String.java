// Daily Challenge 08/25/2023
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int m = s1.length(), n = s2.length(), l = s3.length();
//         if (m + n != l) {
//             return false;
//         }
//         boolean[] dp = new boolean[n + 1];
//         dp[0] = true;
//         for (int j = 1; j <= n; j++) {
//             dp[j] = dp[j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
//         }
//         for (int i = 1; i <= m; i++) {
//             // care this part, if previous false, s1[i-1] == s3[i-1] is meaningless
//             char ci = s1.charAt(i - 1);
//             dp[0] = dp[0] && (ci == s3.charAt(i - 1));
//             boolean p = dp[0];
//             for (int j = 1; j <= n; j++) {
//                 char cj = s2.charAt(j - 1);
//                 char c = s3.charAt(i + j - 1);
//                 dp[j] = (dp[j - 1] && (cj == c)) || (dp[j] && (ci == c));
//                 p = p || dp[j];
//             }
//             if (!p) {
//                 return false;
//             }
//         }
//         return dp[n];

//     }
// }
// TLE dfs
//  improve: add dp to dfs, pair(i1, i2) can be visited more than once
class Solution {
    int[][] dp;
    boolean dfs(char[] c1, char[] c2, char[] c3, int i1, int i2, int i3) {
        if (i1 == c1.length && i2 == c2.length /* && i3 == c3.length */) {
            dp[i1][i2] = 1;
            return true;
        }
        // if (i3 == c3.length) {
        //     return false;
        // }
        if (dp[i1][i2] != 0) {
            return dp[i1][i2] == 1;
        }
        boolean p = false;
        if (i1 < c1.length && c1[i1] == c3[i3]) {
            p = dfs(c1, c2, c3, i1 + 1, i2, i3 + 1);
        }
        if (p) {
            dp[i1][i2] = 1;
            return true;
        }
        if (i2 < c2.length && c2[i2] == c3[i3]) {
            p = dfs(c1, c2, c3, i1, i2 + 1, i3 + 1);
        }
        dp[i1][i2] = p ? 1 : -1;
        return p;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) {
            return false;
        }
        dp = new int[m + 1][n + 1];
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }
}
