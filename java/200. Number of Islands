// Top Interview 150 Graph General Q1
class Solution {
    static final int[] D = new int[] {0, -1, 0, 1, 0};
    int m;
    int n;
    void dfs(char[][] grid, int i, int j) {
        if (i >=m || i < 0 || j >= n || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        // for (int k = 0; k < 4; k++) {
        //     int ii = i + D[k];
        //     int jj = j + D[k + 1];
        //     if (ii >=m || ii < 0 || jj >= n || jj < 0 || grid[ii][jj] != '1') {
        //         continue;
        //     }
        //     dfs(grid, ii, jj);
        // }
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }
}
