class Solution {
    
    int[][] dp;
    boolean[][] flag;
    
    int divisor = 1_000_000_007;
    final int[][] dir = { 
        {0, 1}, {0, -1}, 
        {1, 0}, {-1, 0}
    };

    private int DFS(int[][] grid, int i, int j) {

        //System.out.println(i + "," + j + "," + dp[i][j]);
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
            
        int m = grid.length;
        int n = grid[0].length;
        int result = 1;
        // for (int d = 0; d < 4; d++) {
        //     int nxtI = i + dir[d][0];
        //     int nxtJ = j + dir[d][1];
        //     if (nxtI < 0 || nxtI >= m || nxtJ < 0 || nxtJ >= n) {
        //         continue;
        //     }
        //     if (grid[nxtI][nxtJ] > grid[i][j]) {
        //         DFS(grid, nxtI, nxtJ);
        //         dp[i][j] += dp[nxtI][nxtJ];
        //         if (dp[i][j] > divisor) {
        //             dp[i][j] -= divisor;
        //         }
        //     }
        // } 
        if (i + 1 < m) {
            if (grid[i + 1][j] > grid[i][j]) {
                result += DFS(grid, i + 1, j);
                if (result > divisor) {
                   result -= divisor;
               }
            }
        } 
        if (i > 0) {
            if (grid[i - 1][j] > grid[i][j]) {
                result += DFS(grid, i - 1, j);
                if (result > divisor) {
                   result -= divisor;
               }
            }
        } 
        if (j + 1 < n) {
            if (grid[i][j + 1] > grid[i][j]) {
                result += DFS(grid, i, j + 1);
                if (result > divisor) {
                   result -= divisor;
               }
            }
        } 
        if (j > 0) {
            if (grid[i][j - 1] > grid[i][j]) {
                result += DFS(grid, i, j - 1);
                if (result > divisor) {
                   result -= divisor;
               }
            }
        }
        dp[i][j] = result;
        
        //System.out.println(i + "," + j + "," + dp[i][j]);
        return result;
        //flag[i][j] = true;
    }
    
    public int countPaths(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
            
        dp = new int[m][n];
        //flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0);
            //Arrays.fill(flag[i], false); 
        }
        
        //dp[0][0] = 1;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += DFS(grid, i, j);
                if (ans > divisor) {
                    ans -= divisor;
                //if (flag[i][j]) {
                //    continue;
                //}
                }
            }
        }
        
        // for (int i = 0; i < m; i++) {
        //     System.out.println();
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j]);
        //     }
        // }

        return ans;
    }
}
// sperate the branches and use dp init with 0
