// Daily Question 09/27/2023
class Solution {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        long len = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                len *= c - '0';
            } else {
                len++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= len;
            if (k == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                len /= c - '0';
            } else {
                len--;
            }
        }
        return "";
    }
}
