// Weekly Contest 359 Q2
class Solution {
    public int minimumSum(int n, int k) {
        boolean[] p = new boolean[101];
        int curr = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            while (k - curr >= 0 && p[k - curr]) {
                curr++;
            }
            sum += curr;
            p[curr] = true;
            curr++;
        }
        return sum;
    }
}
