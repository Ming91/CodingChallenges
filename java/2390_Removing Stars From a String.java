// LeetCode 75 Stack Q1
class Solution {
    public String removeStars(String s) {
        int n = s.length();
        char[] ans = new char[n];
        int len = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                len = len == 0 ? 0 : len - 1;
            } else {
                ans[len++] = c;
            }
        }
        return new String(ans, 0, len);
    }
}
// 学好new String()


// class Solution {
//     public String removeStars(String ss) {
//         Stack<Character> s = new Stack<>();
//         StringBuilder sb = new StringBuilder();
//         for (char c : ss.toCharArray()) {
//             if (c == '*') {
//                 sb.deleteCharAt(sb.length() - 1);
//             } else {
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
//     }
// }
