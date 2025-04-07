// Daily Question 10/28/2023
class Solution {
    static final int MOD = 1_000_000_007;
    static final long[][] MAT = new long[][] {
        {0, 1, 0, 0, 0},
        {1, 0, 1, 0, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0},
    };
    long[][] matrixPower(long[][] matrix, int n) {
        long[][] res = new long[][] {
            {1}, {1}, {1}, {1}, {1},
        };
        while (n > 0) {
            if ((n & 1) == 1) {
                res = multiply(matrix, res);
            }
            // matrix = matrix ^ 2, like 100->1000 in binary. 
            matrix = multiply(matrix, matrix);
            n >>= 1;
        }
        return res;
    }
    long[][] multiply(long[][] a, long[][] b) {
        int r = a.length;
        int c = b[0].length;
        int len = a[0].length;
        long[][] res = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] = addMod(res[i][j], a[i][k] * b[k][j]);
                }
            }
        }
        return res;
    }
    long addMod(long x, long y) {
        return (x + y) % MOD;
    }
    public int countVowelPermutation(int n) {
        long[][] res = matrixPower(MAT, n - 1);
        long ans = 0;
        for (long[] x : res) {
            ans = addMod(ans, x[0]);
        }
        return (int)ans;
    }
}
// [Ming]
//  Thought the matrix mul as DP transaction. 
//  But impl the mul wrong!!!!
