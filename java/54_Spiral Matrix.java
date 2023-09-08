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
        while (cnt < m * n) {
            while (si >= 0 && si < m && sj >= 0 && sj < n && matrix[si][sj] < 101) {
                ans.add(matrix[si][sj]);
                matrix[si][sj] = 101;
                si += DIR[d][0];
                sj += DIR[d][1];
                cnt++;
            }
            si -= DIR[d][0];
            sj -= DIR[d][1];
            d = (d + 1) % 4;
            si += DIR[d][0];
            sj += DIR[d][1];
        }
        return ans;
    }
}
// use matrix array as visited, more clear than calculate bounds.
