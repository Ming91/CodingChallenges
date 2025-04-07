// Top Interview 150 Sliding Window Q3
class Solution {
    int m, n, wordLen;
    int subLen;
    Map<String, Integer> wordsCount;
    void slidingWindow(int start, String s, List<Integer> ans) {
        int l = start;
        Map<String, Integer> currCount = new HashMap<>();
        for (int r = start; r <= m - wordLen; r += wordLen) {
            String curr = s.substring(r, r + wordLen);
            // curr word not in dict
            if (!wordsCount.containsKey(curr)) {
                currCount.clear();
                l = r + wordLen;
                continue;
            }
            // over 128, Integer 128 != Integer 128!
            // use equals!!!
            // if (currCount.getOrDefault(curr, 0) == 128) {
            //     System.out.println(wordsCount.get(curr) + "," + currCount.getOrDefault(curr, 0));
            //     System.out.println(wordsCount.get(curr) == (currCount.getOrDefault(curr, 0)));
            // }
            if (wordsCount.get(curr).equals(currCount.getOrDefault(curr, 0))) {
                
                String left = s.substring(l, l + wordLen);
                l += wordLen;
                while (!left.equals(curr)) {
                    currCount.put(left, currCount.get(left) - 1);
                    left = s.substring(l, l + wordLen);
                    l += wordLen;
                }
                currCount.put(curr, currCount.get(curr) - 1);
            }

            currCount.put(curr, currCount.getOrDefault(curr, 0) + 1);
            if (r - l + wordLen == subLen) {
                ans.add(l);
            }
        }
        return ;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        m = s.length();
        n = words.length;
        wordLen = words[0].length();
        subLen = n * wordLen;
        List<Integer> ans = new ArrayList<>();
        if (m < subLen) {
            return ans;
        }
        // System.out.println(subLen);
        wordsCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            wordsCount.put(words[i], wordsCount.getOrDefault(words[i], 0) + 1);
        }
        // System.out.println(wordsCount);
        for (int start = 0; start < wordLen; start++) {
            slidingWindow(start, s, ans);
        }
        return ans;
    }
}
// words are have same length;
// for start in [0, wordLength], start slidingWindow for each start
// in each slidingwindow, just slide wordLength each time.

// use map to solve repeated words situation,
// store words count in each window for validation check.
