// Biweekly Contest 115 Q2
class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int group = groups[0];
        for (int i = 1; i < n; i++) {
            if (groups[i] == group) {
                continue;
            }
            ans.add(words[i]);
            group = groups[i];
        }
        return ans;
    }
}
// [Hint & Beat 99%]
//  Greedily merge all consecutive same groups as one word. 

// [Ming] ugly dp
// class Solution {
//     public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
//         int[] dp = new int[n + 1];
//         int[] prev = new int[n + 1];
//         dp[n] = 0;
//         prev[n] = n;
//         for (int i = n - 1; i >= 0; i--) {
//             prev[i] = n;
//             for (int j = i + 1; j <= n; j++) {
//                 if (dp[i] < dp[j]) {
//                     dp[i] = dp[j];
//                     prev[i] = j;
//                 }
//                 if ((j == n || groups[i] != groups[j]) && dp[i] < dp[j] + 1) {
//                     dp[i] = dp[j] + 1;
//                     prev[i] = j;
//                 }
//             }
//         }
//         // System.out.println(Arrays.toString(dp));
//         // System.out.println(Arrays.toString(prev));
//         int curr = 0;
//         List<String> ans = new ArrayList<>();
//         int last = -1;
//         while (curr < n && prev[curr] < n && dp[curr] == dp[prev[curr]]) {
//             curr = prev[curr];
//         }
//         if (curr < n) {
//             ans.add(words[curr]);
//         } else {
//             return ans;
//         }
//         while (curr < n) {
//             if (prev[curr] < n && dp[curr] != dp[prev[curr]]) {
//                 ans.add(words[prev[curr]]);
//             }
//             curr = prev[curr];
//         }
//         return ans;
//     }
// }
// dp[i] = max(dp[0~j] + 1)
