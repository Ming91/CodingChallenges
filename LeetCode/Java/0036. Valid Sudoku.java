// Top Interview 150 Matrix Q1
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] filled = new boolean[10];
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (filled[board[row][col] - '0']) {
                    return false;
                }
                filled[board[row][col] - '0'] = true;
            }
        }
        
        for (int col = 0; col < 9; col++) {
            boolean[] filled = new boolean[10];
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (filled[board[row][col] - '0']) {
                    return false;
                }
                filled[board[row][col] - '0'] = true;
            }
        }
        for (int block = 0; block < 9; block++) {
            int si = block / 3 * 3;
            int sj = block % 3 * 3;
            boolean[] filled = new boolean[10];
            for (int i = si; i < si + 3; i++) {
                for (int j = sj; j < sj + 3; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (filled[board[i][j] - '0']) {
                        return false;
                    }
                    filled[board[i][j] - '0'] = true;
                }
            }
        }
        return true;
    }
}
// better way:
//  9*9 loop one time: set corresponding check array for each cell;
//  [Improvement] use a 9 length binary number instead of an boolean array.
