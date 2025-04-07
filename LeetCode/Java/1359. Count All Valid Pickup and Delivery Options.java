// Dailly Question 09/10/2023
class Solution {
    static final long[] p = new long[500];
    static {
        p[0] = 1;
    };
    long calcP(int n) {
        if (p[n] != 0) {
            return p[n];
        }
        p[n] = calcP(n - 1) * (n * 2 + 1) * (n + 1) % 1_000_000_007;
        return p[n];
    }
    public int countOrders(int n) {
        return (int)calcP(n - 1);
    }
}
