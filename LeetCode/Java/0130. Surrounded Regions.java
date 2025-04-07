// Top Interview 150 Graph General Q2
class Solution {
    int m, n;
    void dfs(char[][] board, int i, int j, char c) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = c;
        if (i > 0) {
            dfs(board, i - 1, j, c);
        }
        if (i < m - 1) {
            dfs(board, i + 1, j, c);
        }
        if (j > 0) {
            dfs(board, i, j - 1, c);
        }
        if (j < n - 1) {
            dfs(board, i, j + 1, c);
        }

    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, 'o');
            dfs(board, i, n - 1, 'o');
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j, 'o');
            dfs(board, m - 1, j, 'o');
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'o') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
