// Weekly Premium Aug 2023 W4
class Solution {
    static final int[][] DIR = new int[][] {
        {0, 1}, {0, -1},
        {1, 0}, {-1, 0},
    };
    int m, n;
    void dfs(int[][] board, boolean[][] visited, int i, int j) {
        for (int[] d : DIR) {
            int ii = i + d[0], jj = j + d[1];
            while (ii >= 0 && ii < m && jj >= 0 && jj < n &&
                !visited[ii][jj] && board[ii][jj] == board[i][j]) {
                    visited[ii][jj] = true;
                    dfs(board, visited, ii, jj);
                }
        }
        return ;
    }
    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        boolean p = true;
        while (p) {
            p = false;
            // boolean[][] visited = new boolean[m][n];
            // boolean[][] delete = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                int j = 0;
                while (j < n) {
                    if (board[i][j] == 0) {
                        j++;
                        continue;
                    }
                    if (j < n - 2 && //board[i][j] > 0 &&
                        Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) && 
                        Math.abs(board[i][j]) == Math.abs(board[i][j + 2])) {
                        p = true;
                        int k = Math.abs(board[i][j]);
                        while (j < n && Math.abs(board[i][j]) == k) {
                            // delete[i][j] = true; 
                            board[i][j] = -k;
                            j++;   
                        }
                        continue;
                    }
                    j++;
                }
            }
            for (int j = 0; j < n; j++) {
                int i = 0;
                while (i < m && board[i][j] == 0) {
                    i++;
                }
                while (i < m) {
                    if (i < m - 2 && // board[i][j] > 0 &&
                        Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) && 
                        Math.abs(board[i][j]) == Math.abs(board[i + 2][j])) {

                        p = true;
                        int k = Math.abs(board[i][j]);
                        while (i < m && Math.abs(board[i][j]) == k) {
                            // delete[i][j] = true; 
                            board[i][j] = -k;
                            i++;   
                        }
                        continue;
                    }
                    i++;
                }
            }
            // delete for early stop
            for (int j = 0; j < n; j++) {
                int i = m - 1;
                int before = m - 1;

                while (before >= 0 && board[before][j] != 0) {
                    while (before >=0 && board[before][j] < 0) {
                        before--;
                    }
                    if (before < 0) {
                        break;
                    }
                    board[i--][j] = board[before--][j];
                }
                for (int k = i; k >= 0 && board[k][j] != 0; k--) {
                    board[k][j] = 0;
                }
            }
            

        }
        return board;
    }
}
// [ToDo] Improvement:
//  Store modified col idx, just visit modified col when deleting.
