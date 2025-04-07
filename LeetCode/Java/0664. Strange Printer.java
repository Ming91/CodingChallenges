// Daily Challenge 07/30/2023
class Solution {
    int[][] dp;
    char[] ch;

    char[] squash(String s) {
        char[] cha = s.toCharArray();
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cha[i] != cha[last]) {
                cha[++last] = cha[i];
            }
        }
        return Arrays.copyOf(cha, last + 1);
    }
    int calc(int l, int r) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] < r) {
            return dp[l][r];
        }
        int res = 1 + calc(l + 1, r);
        for (int i = l + 1; i <= r; i++) {
            if (ch[i] == ch[l]) {
                res = Math.min(res, calc(l, i - 1) + calc(i + 1, r));
            }
        }
        dp[l][r] = res;
        return res;
    }
    public int strangePrinter(String s) {
        ch = squash(s);
        int n = ch.length;
        dp = new int[n + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, n + 1);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        return calc(0, n - 1);
    }
}
// beat 99% idea:
//  1.压缩, 连续的字符看作一个
//  2.对于[l, r],每个字符循环
//      2.1 idx = l, 直接1 + [l+1, r]
//      2.2 其他a[k] == a[l], 则[l, k - 1] + [k + 1, r], a[l]和a[k]用同一次操作解决

// class Solution {
//     char[] squash(String s) {
//         char[] chars = s.toCharArray();
//         int last = 0;
//         int fullLength = chars.length;
//         for (int i = 1; i < fullLength; i++) {
//             if (chars[i] != chars[last]) {
//                 chars[++last] = chars[i];
//             }
//         }
//         return Arrays.copyOf(chars, last + 1);
//     }
//     public int strangePrinter(String s) {
//         int n = s.length();
//         if (n < 2) {
//             return n;
//         }
//         char[] ch = squash(s);
//         n = ch.length;
//         int[][] dp = new int[n][n];
//         for (int len = 0; len < n; len++) {
//             for (int left = 0; left < n - len; left++) {
//                 int right = left + len;
//                 int j = -1;
//                 dp[left][right] = n;
//                 for (int i = left; i < right; i++) {
//                     if (j < 0 && ch[i] != ch[right]) {
//                         j = i;
//                     }
//                     if (j != -1) {
//                         dp[left][right] = Math.min(dp[left][right], 1 + dp[j][i] + dp[i + 1][right]);
//                     }
//                 }
//                 if (j == -1) {
//                     dp[left][right] = 0;
//                 }
//             }
//         }
//         return 1 + dp[0][n - 1];
//     }
// }

// // 思路1: 两边往中间缩, failed "ababc"
// //   解决?: 多看一位?用stack?
// class Solution {
//     int calc(char[] ch, int l, int r) {
//         if (l == r) {
//             return 1;
//         }
//         char target = ch[l];
//         while (l <= r && ch[l] == target) {
//             l++;
//         }
//         if (l > r) {
//             return 1;
//         }
//         while (l < r && ch[r] == target) {
//             r--;
//         }
//         return 1 + calc(ch, l, r);
//     }
//     public int strangePrinter(String s) {
//         int n = s.length();
//         char[] ch = s.toCharArray();
//         return calc(ch, 0, n - 1);
//     }
// }
