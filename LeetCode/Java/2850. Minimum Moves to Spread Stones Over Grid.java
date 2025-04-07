// Weekly Contest 362 Q3
class Solution {
    static final int[][] DIST = new int[][] {
        {0, 1, 2, 1, 2, 3, 2, 3, 4}, {1, 0, 1, 2, 1, 2, 3, 2, 3}, {2, 1, 0, 3, 2, 1, 4, 3, 2},
        
        {1, 2, 3, 0, 1, 2, 1, 2, 3}, {2, 1, 2, 1, 0, 1, 2, 1, 2}, {3, 2, 1, 2, 1, 0, 3, 2, 1},
        
        {2, 3, 4, 1, 2, 3, 0, 1, 2}, {3, 2, 3, 2, 1, 2, 1, 0, 1}, {4, 3, 2, 3, 2, 1, 2, 1, 0},
    };
    int ans;
    int n;

    void backtrack(List<int[]> options, List<Integer> blanks, int curr, List<Integer> res) {
        if (curr == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += DIST[res.get(i)][blanks.get(i)];
            }
            ans = Math.min(ans, sum);
            return;
        }
        for (int[] option : options) {
            if (option[1] == 0) {
                continue;
            }
            res.add(option[0]);
            option[1]--;
            backtrack(options, blanks, curr + 1, res);
            res.remove(curr);
            option[1]++;
        }
        return;
    }

    public int minimumMoves(int[][] grid) {
        List<int[]> options = new LinkedList<>();
        List<Integer> blanks = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 0) {
                    blanks.add(i * 3 + j);
                }
                if (grid[i][j] > 1) {
                    options.add(new int[] {i * 3 + j, grid[i][j] - 1});
                }
            }
        }
        ans = 200;
        n = blanks.size();
        backtrack(options, blanks, 0, new ArrayList<>());
        return ans;
    }
}
