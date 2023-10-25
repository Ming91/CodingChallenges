// Biweekly Contest 115 Q3
class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[] dp = new int[n];
        int[] next = new int[n];
        Map<String, List<Integer>> strToIdxMap = new HashMap<>();
        int maxIdx = n;
        for (int i = n - 1; i >= 0; i--) {
            int prevIdx = n;
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                // convert word to pattern with '*'.
                char temp = word[j];
                word[j] = '*';
                String curr = new String(word);

                // search matches and update dp. 
                List<Integer> prevList = strToIdxMap.getOrDefault(curr, List.of());
                for (int prev : prevList) {
                    if (groups[prev] == groups[i] || dp[prev] < dp[i]) {
                        continue;
                    }
                    dp[i] = dp[prev] + 1;
                    prevIdx = prev;
                }

                // append current pattern to dictionary.
                strToIdxMap.computeIfAbsent(curr, k -> new ArrayList<>()).add(i);

                // restore pattern to orignal word.
                word[j] = temp;
            }
            if (maxIdx >= n || dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
            next[i] = prevIdx;
        }
        int curr = maxIdx;
        List<String> ans = new ArrayList<>();
        while (curr < n) {
            ans.add(words[curr]);
            curr = next[curr];
        }
        return ans;
    }
}
// [Beat 99%]
//  Store all possible match patterns(string replace one char with '*') to a dictionary. 
//  update dp with its match. 

// [Ming] Check each pair of indices, and update state using DP. 
// class Solution {
//     boolean isValid(int i, int j, String[] words, int[] groups) {
//         if (j >= words.length) {
//             return true;
//         }
//         if (groups[i] == groups[j]) {
//             return false;
//         }
//         if (words[i].length() != words[j].length()) {
//             return false;
//         }
//         int count = 0;
//         for (int k = 0; k < words[i].length(); k++) {
//             if (words[i].charAt(k) != words[j].charAt(k)) {
//                 count++;
//                 if (count > 1) {
//                     return false;
//                 }
//             }
//         }
//         return count == 1;
//     }
//     public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        
//         int[] dp = new int[n + 1];
//         int[] prev = new int[n + 1];
//         int max = 0;
//         int start = n;
//         dp[n] = 0;
//         prev[n] = n;
//         for (int i = n - 1; i >= 0; i--) {
//             prev[i] = n;
//             for (int j = i + 1; j <= n; j++) {
//                 // if (dp[i] < dp[j]) {
//                 //     dp[i] = dp[j];
//                 //     prev[i] = n;
//                 // }
//                 if (isValid(i, j, words, groups) && dp[i] < dp[j] + 1) {
//                     dp[i] = dp[j] + 1;
//                     prev[i] = j;
//                     if (max < dp[i]) {
//                         max = dp[i];
//                         start = i;
//                     }
//                 }
//             }
//         }
//         // System.out.println(Arrays.toString(dp));
//         // System.out.println(Arrays.toString(prev));
//         List<String> ans = new ArrayList<>();
//         int curr = start;
//         while (curr < n) {
//             ans.add(words[curr]);
//             curr = prev[curr];
//         }
//         return ans;
//     }
// }
