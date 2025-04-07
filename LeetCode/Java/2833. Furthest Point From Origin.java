// Weekly Contest 360 Q1
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans = 0, n = moves.length();
        int dash = 0;
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'L') {
                ans++;
            } else {
                if (moves.charAt(i) == 'R') {
                    ans--;
                } else {
                    dash++;
                }
            }
        }
        return Math.abs(ans) + dash;
    }
}
