// Top Interview 150 Two Pointers Q2
// LeetCode 75 Two Pointers Q2
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0) {
            return true;
        }
        if (m < n) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int is = 0, it = 0;
        while (is < n && it < m) {
            if (cs[is] == ct[it]) {
                is++;
            }
            it++;
        }
        return is == n;
    }
}
// char[] faster

// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         if (s.length() == 0) {
//             return true;
//         }
//         if (t.length() == 0) {
//             return false;
//         }
//         int is = 0, it = 0;
//         char cs = s.charAt(is);
//         while (is < s.length() && it < t.length()) {
//             if (cs == t.charAt(it)) {
//                 is++;
//                 it++;
//                 if (is == s.length()) {
//                     return true;
//                 }
//                 cs = s.charAt(is);
//             } else {
//                 it++;
//             }
//         }
//         if (is < s.length()) {
//             return false;
//         } else {
//             return true;
//         }
//     }
// }
