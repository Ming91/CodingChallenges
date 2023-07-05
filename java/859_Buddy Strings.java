class Solution {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        int l = -1, k = -1;
        int maxCount = 0;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (maxCount < 2) {
                int temp = ++count[s.charAt(i) - 'a'];
                maxCount = maxCount < temp ? temp : maxCount;
            }
            if (s.charAt(i) == goal.charAt(i)) {
                continue;
            }
            if (l < 0) {
                l = i;
                continue;
            }
            if (k > 0) {
                return false;
            }
            k = i;
        }
        // all same
        if (l == -1) {
            // exist pair of same char
            if (maxCount >= 2) {
                return true;
            }

            // no such pair, cant swap
            return false;
        }
        // just one different
        if (k == -1) {
            return false;
        }
        if (s.charAt(l) == goal.charAt(k)
        &&  s.charAt(k) == goal.charAt(l)) {
            return true;
        }
        return false;
    }
}
// 要考虑相等且无重复的情况,无法换
// 用toCharArray好像更快?
