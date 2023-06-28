class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int s = m < n ? m : n;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s; i++) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
        }
        ans.append(word1.substring(s));
        ans.append(word2.substring(s));
        return ans.toString();
    }
}
