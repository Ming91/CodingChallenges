// Daily Question 09/23/2023
class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            int curr = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String prevWord = sb.toString();
                int prev = map.getOrDefault(prevWord, 0);
                curr = Math.max(curr, prev + 1);
            }
            map.put(word, curr);
            max = Math.max(max, curr);
        }
        return max;
    }
}
// [Editorial] use deleteCharAt to acclerate compare.

// TODO: [Beat 99%] word.length <= 16, can use bucket sort/ String[] to manage.
//  And process them by each length.

// [Ming] compare each pair solution, not efficient enough. 
// class Solution {
//     boolean isPredecessor(String s1, String s2) {
//         int m = s1.length();
//         int n = s2.length();
//         if (m + 1 != n) {
//             return false;
//         }
//         int i1 = 0;
//         int i2 = 0;
//         int count = 0;
//         while (i1 < m && i2 < n && count < 2) {
//             if (s1.charAt(i1) != s2.charAt(i2)) {
//                 count++;
//                 i1--;
//             }
//             i1++;
//             i2++;
//         }
//         if (count == 2) {
//             return false;
//         }
//         return true;
//     }
//     public int longestStrChain(String[] words) {
//         int n = words.length;
//         Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
//         int[] dp = new int[n];
//         int max = 0;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (isPredecessor(words[i], words[j])) {
//                     dp[j] = Math.max(dp[j], dp[i] + 1);
//                     max = Math.max(max, dp[j]);
//                 }
//             }
//         }
//         return max + 1;
//     }
// }
