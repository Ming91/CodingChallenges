// Top Interview 150 Sliding Window Q2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] inString = new boolean[255];
        int n = s.length();
        int l = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (inString[s.charAt(i)]) {
                while (inString[s.charAt(i)]) {
                    inString[s.charAt(l++)] = false;
                }
            }
            inString[s.charAt(i)] = true;
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
