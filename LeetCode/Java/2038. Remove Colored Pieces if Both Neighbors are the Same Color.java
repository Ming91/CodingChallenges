// Daily Question 10/02/2023
class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int a = 0, b = 0;
        char[] c = colors.toCharArray();
        for (int i = 1; i < n - 1; i++) {
            if (c[i] == 'A' && c[i - 1] == 'A' && c[i + 1] == 'A') {
                a++;
            }
            if (c[i] == 'B' && c[i - 1] == 'B' && c[i + 1] == 'B') {
                b++;
            }
        }
        return a > b;
    }
}
