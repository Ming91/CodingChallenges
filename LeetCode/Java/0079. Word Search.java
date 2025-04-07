// Top Interview 150 Backtracking Q7
class Solution {
    int m, n;
    boolean backtrack(int x, int y, char[][] board, char[] w, int curr) {
        if (w.length == 1 || curr == w.length) {
            return true;
        }
        if (board[x][y] != w[curr]) {
            return false;
        }
        char c = board[x][y];
        board[x][y] = '#';
        if (x < m - 1 && backtrack(x + 1, y, board, w, curr + 1)) {
            return true;
        }
        if (x > 0 && backtrack(x - 1, y, board, w, curr + 1)) {
            return true;
        }
        if (y < n - 1 && backtrack(x, y + 1, board, w, curr + 1)) {
            return true;
        }
        if (y > 0 && backtrack(x, y - 1, board, w, curr + 1)) {
            return true;
        }
        board[x][y] = c;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if (word.length() > m * n) {
            return false;
        }

        // Pruning
        int[] count = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[board[i][j]]++;
            }
        }
        for (char c : word.toCharArray()) {
            count[c]--;
            if (count[c] < 0) {
                return false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(i, j, board, word.toCharArray(), 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
// [Beat 99%]
//  Use count to prune.
//  [TODO] Use count to start from the char with less count. 
