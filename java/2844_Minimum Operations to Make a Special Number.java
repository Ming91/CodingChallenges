// Weekly Contest 361 Q2
class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        int ans = n;
        int res = 0;
        int last0 = -1, last5 = -1;
        int first2 = -1, first0 = -1, first5 = -1, first7 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') {
                res++;
            }
            if (last0 > 0 && first0 < 0 && num.charAt(i) == '0') {
                first0 = i;
                ans = Math.min(ans, n - i - 2);
                continue;
            }
            if (last0 > 0 && first5 < 0 && num.charAt(i) == '5') {
                first5 = i;
                ans = Math.min(ans, n - i - 2);
                continue;
            }
            if (last5 > 0 && first2 < 0 && num.charAt(i) == '2') {
                first2 = i;
                ans = Math.min(ans, n - i - 2);
                continue;
            }
            if (last5 > 0 && first7 < 0 && num.charAt(i) == '7') {
                first7 = i;
                ans = Math.min(ans, n - i - 2);
                continue;
            }
            if (last0 < 0 && num.charAt(i) == '0') {
                last0 = i;
                continue;
            }
            if (last5 < 0 && num.charAt(i) == '5') {
                last5 = i;
                continue;
            }
        }
        // System.out.println(first5 + ", " + last0);
        return Math.min(ans, res);
    }
}
