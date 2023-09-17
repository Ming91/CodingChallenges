// Top Interview 150 Sliding Window Q4
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        char[] sChar = s.toCharArray();
        int diff = 'z' - 'A' + 1;
        int[] count = new int[diff];
        
        for (char c : t.toCharArray()) {
            count[c - 'A']++;
        }

        int l = 0, r = 0;
        int remain = n;
        int ans = m + 1, ansIdx = 0;
        while (r < m) {
            char right = sChar[r++];
            if (count[right - 'A'] > 0) {
                remain--;
            }
            count[right - 'A']--;

            while (remain == 0) {
                if (ans > r - l) {
                    ans = r - l;
                    ansIdx = l;
                }
                char left = sChar[l];
                count[left - 'A']++;
                if (count[left - 'A'] > 0) {
                    remain++;
                }
                l++;
            }
        }
        return ans == m + 1 ? "" : s.substring(ansIdx, ansIdx + ans);
    }
}
// [Beat 99%] Improvement:
//  Use count['z' - 'A' + 1] to store count in target.
//  For right side of the sliding window, count--, if corresponding count > 0, means this char is needed.
//  So remain--.
//  When remain == 0, sliding left until invalid. For each removed left char, count++. Invalid means a count is changed from 0 to 1.

// [Ming]:
//  store count for target string and sliding window.
//  be care of [aaaaaaabbc] w/ [abc], window count can exceed target count
//  but at the edge condition, remaining pair count needs to be modified.
// class Solution {
//     public String minWindow(String s, String t) {
//         int m = s.length(), n = t.length();
//         if (m < n) {
//             return "";
//         }
//         if (s.equals(t)) {
//             return s;
//         }
//         Map<Character, Integer> tCount = new HashMap<>();
//         Map<Character, Integer> windowCount = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             tCount.put(c, tCount.getOrDefault(c, 0) + 1);
//         }
//         int remain = n;
//         int l = 0, r = 0;
//         int ans = m + 1, ansIdx = 0;
//         while (r < m) {
//             while (r < m && remain > 0) {
//                 char c = s.charAt(r);
//                 if (tCount.containsKey(c)) {
//                     windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
//                     if (tCount.get(c) >= windowCount.get(c)) {
//                         remain--;
//                     }
//                 }
//                 r++;
//             }
//             if (ans > m && r == m && remain > 0) {
//                 return "";
//             }
//             // if (r - l < ans) {
//             //     ans = r - l;
//             //     ansIdx = l;
//             // }
//             while (l < r && remain == 0) {
//                 char c = s.charAt(l);
//                 if (tCount.containsKey(c)) {
//                     if (tCount.get(c).equals(windowCount.get(c))) {
//                         if (r - l < ans) {
//                             ans = r - l;
//                             ansIdx = l;
//                         }
//                         remain++;
//                     }
//                     windowCount.put(c, windowCount.getOrDefault(c, 0) - 1);
//                 }
//                 l++;
//             }
//         }
//         return s.substring(ansIdx, ansIdx + ans);
//     }
// }
