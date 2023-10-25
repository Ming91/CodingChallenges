// Weekly Contest 367 Q4
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        // 12345 = 3 * 5 * 823;
        int m = grid.length;
        int n = grid[0].length;
        int[][] p = new int[m][n];
        int len = m * n;
        int[] prev = new int[len];
        int[] next = new int[len];
        prev[0] = 1;
        next[len - 1] = 1;
        int idx = 1;
        boolean zero = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int curr = j == 0 ? grid[i - 1][n - 1] : grid[i][j - 1];
                curr = curr % MOD;
                prev[idx] = (prev[idx - 1] * curr) % MOD;
                if (prev[idx] == 0) {
                    zero = true;
                    break;
                }
                idx++;
            }
            if (zero) {
                break;
            }
        }
        // System.out.println(Arrays.toString(prev));
        idx = len - 2;
        zero = false;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    p[i][j] = prev[len - 1];
                    continue;
                }
                int curr = j == n - 1 ? grid[i + 1][0] : grid[i][j + 1];
                curr = curr % MOD;
                next[idx] = (next[idx + 1] * curr) % MOD;
                p[i][j] = (prev[idx] * next[idx]) % MOD;
                if (next[idx] == 0) {
                    zero = true;
                    break;
                }
                idx--;
            }
            if (zero) {
                break;
            }
        }
        return p;
    }
}
// [TODO]
//  Better way is to really flatten the grid. 
//  n*m <= 10^5, so just do it. 
// [Ming]
//  Flatten the grid as an array. 
