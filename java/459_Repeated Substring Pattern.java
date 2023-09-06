// Daily Challenge 08/21/2023
// class Solution {
//     int[] nextTable(char[] pattern) {
//         int n = pattern.length;
//         if (n == 1) {
//             return new int[] {0};
//         }
//         // know as lps, longest previous substring
//         //  
//         int[] next = new int[n];
        
//         // version 1: next[j] is maxlen prefix ended with s[j], 
//         //            fall back to next[j - 1] if pattern[j] != text[i]

//         int pos = 1, len = 0;
//         next[0] = 0;
//         // while (pos < n) {
//         //     if (pattern[pos] == pattern[len]) {
//         //         len++;
//         //         next[pos++] = len;        
//         //     } else {
//         //         if (len > 0) {
//         //             len = next[len - 1];
//         //         } else {
//         //             next[pos++] = 0;
//         //         }
//         //     }
//         // }
//         // for version
//         for (pos = 1; pos < n; pos++) {
//             while (len > 0 && pattern[pos] != pattern[len]) {
//                 len = next[len - 1];
//             }
//             if (pattern[pos] == pattern[len]) {
//                 len++;
//             }
//             next[pos] = len;
//         }

//         // version 2: next[j] is where you should fall back if mismatched
//         //          aka, right shift version 1

//         // int pos = 2, len = 0;
//         // next[0] = -1;
//         // next[1] = 0;
//         // while (pos < n) {
//         //     if (pattern[pos - 1] == pattern[len]) {
//         //         len++;
//         //         next[pos++] = len;
//         //     } else {
//         //         if (len > 0) {
//         //             len = next[len];
//         //         } else {
//         //             next[pos++] = 0;
//         //         }
//         //     }
//         // }

//         // version 3: substract by 1
//         // the nearest idx that s[next[j]] == s[j] and can fall back to next[j]

//         // int pos = 1, len = -1;
//         // next[0] = -1;
//         // while (pos < n) {
//         //     if (pattern[pos] == pattern[len + 1]) {
//         //         len++;
//         //         next[pos++] = len;
//         //     } else {
//         //         if (len >= 0) {
//         //             // s[pos] != s[len + 1]
//         //             // but s[pos - 1] == s[len] == s[next[len]]
//         //             // so fall back to next[len]
//         //             len = next[len];
//         //         } else {
//         //             next[pos++] = -1;
//         //         }
//         //     }
//         // }
//         // for (pos = 1; pos < n; pos++) {
//         //     while (len >= 0 && pattern[pos] != pattern[len + 1]) {
//         //         len = next[len];
//         //     }
//         //     // if don't compare, all skip and all == -1 if s[1:] != s[0:]
//         //     if (pattern[pos] == pattern[len + 1]) {
//         //         len++;
//         //     }
//         //     next[pos] = len;
//         // }
//         return next;
        
//     }
//     int kmp(char[] text, char[] pattern) {
//         if (pattern.length > text.length) {
//             return -1;
//         }
//         int[] next = nextTable(pattern);
//         // System.out.println(Arrays.toString(next));
//         int m = text.length, n = pattern.length;
//         int i = 0, j = 0;

//         // // version 1
//         // while (m - i >= n - j) {
//         //     if (text[i] == pattern[j]) {
//         //         i++;
//         //         j++;
//         //         if (j == n) {
//         //             return m - j;
//         //         }
//         //         continue;
//         //     }
//         //     while (j > 0 && text[i] != pattern[j]) {
//         //         j = next[j - 1];
//         //     }
//         //     if (text[i] == pattern[j]) {
//         //         j++;
//         //     }
//         //     // j++;
//         //     i++;
            
//         // }
//         for (i = 0; i <= m - (n - j); i++) {
//             // be care of the order: if 'if' first then while, 
//             // may cause text[i] miss the suitable pattern[j]
//             while (j > 0 && text[i] != pattern[j]) {
//                 j = next[j - 1];
//             }
//             if (text[i] == pattern[j]) {
//                 j++;
//                 if (j == n) {
//                     return m - j;
//                 }
//                 continue;
//             }
            
//         }

//         // verision 2
//         // while (m - i >= n - j) {
//         //     if (text[i] == pattern[j]) {
//         //         i++;
//         //         j++;
//         //         if (j == n) {
//         //             return m - j;
//         //         }
//         //         continue;
//         //     }
//         //     while (j >= 0 && text[i] != pattern[j]) {
//         //         j = next[j];
//         //     }
//         //     i++;
//         //     j++;
//         // }

//         // version 3
//         // j = -1;
//         // while (m - i >= n - 1 - j) {
//         //     if (text[i] == pattern[j + 1]) {
//         //         i++;
//         //         j++;
//         //         if (j == n - 1) {
//         //             return m - j - 1;
//         //         }
//         //         continue;
//         //     }
//         //     while (j >= 0 && text[i] != pattern[j + 1]) {
//         //         j = next[j];
//         //     }
//         //     if (text[i] == pattern[j + 1]) {
//         //         j++;
//         //     }
//         //     i++;
//         // }
//         return -1;
//     }
//     public boolean repeatedSubstringPattern(String s) {
//         String t = s + s;
//         t = t.substring(1, t.length() - 1);
//         // s = "aba";
//         // String t = "bbaaba";
//         char[] cht = t.toCharArray();
//         char[] chs = s.toCharArray();
//         // System.out.println(kmp(cht, chs));
//         return kmp(cht, chs) >= 0;
//     }
// }
// kmp:
//  1. two strings, text and pattern. generate next[] for pattern
//  2. compare text[i] and pattern[j], if not equal, j update to suitable idx using next[]
//  gen next:
//      def: next[j] is the max length of prefix of whole string that ended with pattern[j]
//      就是从j往前找，直到[j - next[j], j]是整个串的prefix, 存最大的
//      既是这样的prefix的最大长度, 也是回退时该退到的idx(0 ~ len - 1都一样, 从len开始比)
//      eg: j处不等, 退回到next[j - 1]处
//      不同版本是回退时操作不同
//      a  a  b  a  a  f
//      0  1  0  1  2  0     prefix: - a - a aa -
//      multiple versions:
//     -1  0  1  0  1  2     shift 1 pos to right, [0] = -1
//     -1  0 -1  0  1 -1     subtract by 1, for union j++ in while loop(guess)
//                           means the nearest idx that s[next[j]] == s[j] and can fall back to next[j]


// better perspective:
//  1. first step:
//      s = p * k, then `rotate` s with p, then rotated s = s
//      eg: abcabc, rotate 1, bcabca, rotate 2, cabcab, rotate 3, abcabc
//      for each n % k == 0, compare s.substring(0, k) with s.substring(len - k, len)
//                           compare s.substring(k, len) with s.substring(0, len - k)
//                           AKA: compare origianl s with rotated k s.
//  2. one step more:
//      better way to see if a string s` is a roated s:
//      make t = s + s, then t must contains s` as substring
//  2.1 string concatenation way for this problem:
//      if s = p * k, s + s = first + remain1 + p * (k - 1) + p * (k - 1) + remain2 + last
//      if k > 1, p * (2k - 2) >= p * k, (s + s - first - last) contains s

// class Solution {
//     public boolean repeatedSubstringPattern(String s) {
//         String t = s + s;
//         if (t.substring(1, t.length() - 1).contains(s)) {
//             return true;
//         }
//         return false;
//     }
// }

// naive idea:
//  for each n % k == 0, repeat compare s.substring(0, k) for n / k times

// use string.repeat()
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= (n >> 1); i++) {
            if (n % i != 0 || s.charAt(i) != s.charAt(0)) {
                continue;
            } 
            
            int k = n / i;
            String sub = s.substring(0, i);
            if (sub.repeat(k).equals(s)) {
                return true;
            }
        }
        return false;
    }
}
// string.repeat(k) introduced in JDK 11
// string.substring(i) means start at i. if need end at i, use substring(0, i)

// naive charversion
// class Solution {
//     public boolean repeatedSubstringPattern(String s) {
//         int n = s.length();
//         char[] ch = s.toCharArray();
//         for (int i = 1; i <= n / 2; i++) {
//             if (n % i == 0) {
//                 boolean p = true;
//                 int remainder = 0;
//                 for (int j = i; j < n; j++) {
//                     if (ch[j] != ch[remainder++]) {
//                         p = false;
//                         break;
//                     }
//                     if (remainder == i) {
//                         remainder = 0;
//                     }
//                 }
//                 if (p) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
