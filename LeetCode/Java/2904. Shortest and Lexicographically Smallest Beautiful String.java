// Weekly Contest 367 Q2
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l = 0;
        while (l < n && s.charAt(l) != '1') {
            l++;
        }
        int r = l;
        int count = 0;
        String ans = "";
        while (r < n) {
            if (s.charAt(r) == '1') {
                count++;
            }
            if (count == k) {
                String curr = s.substring(l, r + 1);
                if (ans.length() == 0 || curr.length() < ans.length() || 
                    (curr.length() == ans.length() && ans.compareTo(curr) > 0)) {
                    ans = curr;
                }
                l++;
                while (l < n && s.charAt(l) != '1') {
                    l++;
                }
                count--;
            }
            r++;
        }
        return ans;
    }
}
// [Ming] Better structure in one loop. 

// [Ming] Not so good solution. 
// class Solution {

//     public String shortestBeautifulSubstring(String s, int k) {
//         int count = 0;
//         int len = 0;
//         int n = s.length();
//         for (; len < s.length(); len++) {
//             if (s.charAt(len) == '1') {
//                 count++;
//             }
//             if (count == k) {
//                 break;
//             }
//         }
//         if (len == s.length()) {
//             return "";
//         }
//         int l = 0;
//         while (l < len && s.charAt(l) != '1') {
//             l++;
//         }
//         int r = len;
//         String ans = s.substring(l, r + 1);
//         while (l <= r) {
//             r++;
//             l++;
//             while (r < n && s.charAt(r) != '1') {
//                 r++;
//             }
//             if (r == n) {
//                 break;
//             }
//             while (l <= r && s.charAt(l) != '1') {
//                 l++;
//             }
//             String curr = s.substring(l, r + 1);
//             // System.out.println(curr);
//             if (r - l + 1 < ans.length() || (r - l + 1 == ans.length() && curr.compareTo(ans) < 0)) {
//                 ans = curr;
//             }
//         }
//         return ans;
//     }
// }
