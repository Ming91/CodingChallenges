// Top Interview 150 Q19
class Solution {
    public int lengthOfLastWord(String s) {
        // s = s.trim();
        // return s.length() - s.lastIndexOf(' ') - 1;
        
        int n = s.length();
        int ans = 0, i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            ans++;
            i--;
        }
        return ans;
    }
}
