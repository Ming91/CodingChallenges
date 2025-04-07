// Weekly Contest 359 Q1
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int len = 0;
        if (s.length() != words.size()) {
            return false;
        }
        for (String word : words) {
            if (len < s.length() && word.charAt(0) == s.charAt(len)) {
                len++;
            } else {
                return false;
            }
        }
        return true;
    }
}
