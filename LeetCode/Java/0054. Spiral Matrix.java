// Top Interview 150 Matrix Q2
class Solution {
    static final int[][] DIR = new int[][] {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        int si = 0, sj = 0;
        int d = 0;
        int i = 0, j = -1, dd = 1;
        int col = 0, row = 0;
        while (col < m && row < n) {
            // [Better]
            for (int x = 0; x < n - row; x++) {
                j += dd;
                ans.add(matrix[i][j]);
            }
            col++;
            for (int x = 0; x < m - col; x++) {
                i += dd;
                ans.add(matrix[i][j]);
            }
            row++;
            dd *= -1;
            // 
            // while (si >= 0 && si < m && sj >= 0 && sj < n && matrix[si][sj] < 101) {
            //     ans.add(matrix[si][sj]);
            //     matrix[si][sj] = 101;
            //     si += DIR[d][0];
            //     sj += DIR[d][1];
            //     cnt++;
            // }
            // si -= DIR[d][0];
            // sj -= DIR[d][1];
            // d = (d + 1) % 4;
            // si += DIR[d][0];
            // sj += DIR[d][1];
        }
        return ans;
    }
}
// use matrix array as visited, more clear than calculate bounds.

// [Better] idea: use two var to calculate bound, each time + 1.
//                make 4 dirs to 2: col and row +1 or -1
