// Biweekly Contest 111 Q2
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int m = str1.length(), n = str2.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (ch1[i] == ch2[j] || ch1[i] == ch2[j] - 1 || ch1[i] - ch2[j] == 25) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}
