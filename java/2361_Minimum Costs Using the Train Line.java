// Weekly Premium August 2023 W1
class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long dpR = 0;
        long dpE = expressCost;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long r = dpR + regular[i];
            long e = dpE + express[i];
            if (r > e) {
                dpR = e;
                dpE = e;
                ans[i] = e;
            } else {
                dpR = r;
                ans[i] = r;
                dpE = Math.min(e, r + expressCost);
            }
        }
        return ans;
    }
}
