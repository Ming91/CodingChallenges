// Daily Question 10/27/2023
class Solution {
    String manacher(String origin) {
        StringBuilder sb = new StringBuilder("|");
        for (char c : origin.toCharArray()) {
            sb.append(c).append("|");
        }
        String s = sb.toString();
        int n = s.length();
        int center = 0;
        int radius = 0;
        int[] palindromeRadius = new int[n];
        int maxCenter = 0;
        for (int i = 0; i < n; i++) {
            int mirror = (center << 1) - i;
            if (i < radius) {
                palindromeRadius[i] = Math.min(radius - i, palindromeRadius[mirror]);
            }
            while (i + 1 + palindromeRadius[i] < n &&
                   i - 1 - palindromeRadius[i] >= 0 &&
                   s.charAt(i + 1 + palindromeRadius[i]) == 
                   s.charAt(i - 1 - palindromeRadius[i])) {
                
                palindromeRadius[i]++;

            }
            if (i + palindromeRadius[i] > radius) {
                center = i;
                radius = i + palindromeRadius[i];
            }
            if (palindromeRadius[i] > palindromeRadius[maxCenter]) {
                maxCenter = i;
            }
        }
        // sb.setLength(0);
        // for (int i = maxCenter - palindromeRadius[maxCenter];
        //         i <= maxCenter + palindromeRadius[maxCenter]; i++) {
            
        //     if (s.charAt(i) == '|') {
        //         continue;
        //     }
        //     sb.append(s.charAt(i));
        // }
        // return sb.toString();
        
        // The start and end of pali is always the seperator "|",
        // and each "|" idx/2 will get the char before it. 
        // so start = (c - r) / 2, end = (c + r) / 2.
        // or we can see the length of pali in modified string is always odd.
        // so r = (modified_len - 1) / 2 = origin_len
        int start = (maxCenter - palindromeRadius[maxCenter]) >> 1;
        int end = start + palindromeRadius[maxCenter];
        return origin.substring(start, end);
    }
    public String longestPalindrome(String s) {
        return manacher(s);
    }
}
// [Editorial] [Manacher's Algo]
//  ^...m..c..i...r
//  i: current index, r: 'farthest' index that a pali reached,
//  c: the center of pali of r, m: mirror of i.
//  radius[i] start from min(r-i, radius[m]), 
//  then continue to expand until invalid.
//  So we can see the loop always add some new chars later than r to compare.
//  Or the inner while loop stop at first. 
//  In this way we can see it is O(n). 


// [Ming] Iteration all center and find each length. 
// class Solution {
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         char[] ch = s.toCharArray();
//         int l = 0;
//         int r = 0;
//         String ans = Character.toString(ch[0]);
//         for (int i = 1; i < n - 1; i++) {
//             if (ch[i - 1] == ch[i + 1]) {
//                 l = i;
//                 r = i;
                
//                 while (l >= 0 && r < n && ch[l] == ch[r]) {
//                     l--;
//                     r++;
//                 }
//                 l++;
//                 r--;
//                 if (ans.length() < r - l + 1) {
//                     ans = s.substring(l, r + 1);
//                 }
//             }
//         }
//         for (int i = 0; i < n - 1; i++) {
//             if (ch[i] == ch[i + 1]) {
//                 l = i;
//                 r = i + 1;
//                 while (l >= 0 && r < n && ch[l] == ch[r]) {
//                     l--;
//                     r++;
//                 }
//                 l++;
//                 r--;
//                 if (ans.length() < r - l + 1) {
//                     ans = s.substring(l, r + 1);
//                 }
//             }
//         }
//         return ans;
//     }
// }
