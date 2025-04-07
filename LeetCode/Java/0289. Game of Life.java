// Top Interview 150 Matrix Q5
class Solution {
    static final int[] StateToCurr = new int[] {0, 1, 1, 0};
    static final int[][] PrevCurrToState = new int[][] {
        {0, 2}, {3, 1},
    };
    static final int[][] DIR = new int[][] {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1}, {1, 0}, {1, 1},
    };
    static final int LIVE = 1, DEAD = 0;
    int m, n;

    int interact(int[][] board, int i, int j) {
        int prev = board[i][j];
        // Rule 2
        int curr = prev;
        int sum = 0;
        for (int[] d : DIR) {
            int ii = i + d[0], jj = j + d[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n) {
                continue;
            }
            sum += board[ii][jj] % 2;
        }
        // Rule 1, 3
        if (prev == LIVE && (sum < 2 || sum > 3)) {
            curr = DEAD;
        }
        // Rule 4
        if (prev == DEAD && sum == 3) {
            curr = LIVE;
        }
        return curr;
    }

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int prev = board[i][j];
                int curr = interact(board, i, j);
                board[i][j] = PrevCurrToState[prev][curr];
            }
        }
        // System.out.println(Arrays.deepToString(board));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = StateToCurr[board[i][j]];
            }
        }
    }
}

// state: 0: 0->0, 1: 1->1, 2: 0->1, 3: 1->0;
// state to prev: state % 2
// state to curr: StateToCurr[state]
