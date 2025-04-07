// Top Interview 150 Hashmap Q4
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if (m != n) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] sCount = new int[26];
        for (char c : sChar) {
            sCount[c - 'a']++;
        }
        for (char c : tChar) {
            if (sCount[c - 'a'] == 0) {
                return false;
            }
            sCount[c - 'a']--;
        }
        return true;
    }
}
