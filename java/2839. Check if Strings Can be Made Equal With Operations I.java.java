// Biweekly Contest 112 Q1
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] even = new int[26];
        int[] odd  = new int[26];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            } else {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (odd[i] != 0 || even[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
