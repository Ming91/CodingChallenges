// Top Interview 150 Two Pointers Q1
class Solution {
    public boolean isPalindrome(String s) {
        // s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        // System.out.println(s);
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) {
                return false;
            }
        }
        return true;
    }
}
