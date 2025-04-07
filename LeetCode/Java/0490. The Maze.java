// Weekly Premium Aug 2023 W3
class Solution {
    static final int[][] DIR = new int[][] {
        {0, 1}, {0, -1},
        {1, 0}, {-1, 0}
    };

    int[] dest;
    int[][] g;
    boolean[][][] visited;
    int m;
    int n;
    boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        if (g[x][y] == 1) {
            return false;
        }
        return true;
    }
    boolean dfs(int x, int y, int di) {
        if (isValid(x + DIR[di][0], y + DIR[di][1])) {
            if (visited[x + DIR[di][0]][y + DIR[di][1]][di]) {
                return false;
            }
            visited[x + DIR[di][0]][y + DIR[di][1]][di] = true;

            return dfs(x + DIR[di][0], y + DIR[di][1], di);
        }
        // if not hit the wall, the ball won't stop
        if (x == dest[0] && y == dest[1]) {
            return true;
        }
        for (int ii = di + 1; ii < di + 4; ii++) {
            int i = ii % 4;
            
            int[] d = DIR[i];

            // Method 2 : try to hit the wall, then dfs. awful structure.
            // int xx = x, yy = y;
            // while (isValid(xx + d[0], yy + d[1])) {
            //     xx += d[0];
            //     yy += d[1];
            //     visited[xx][yy][i] = true;

            // }
            // if (xx == dest[0] && yy == dest[1]) {
            //     return true;
            // }
            // for (int jj = i + 1; jj < i + 4; jj++) {
            //     int j = jj % 4;
            //     if (!visited[xx][yy][j]) {
            //         visited[xx][yy][j] = true;
            //         if (dfs(xx, yy, j)) {
            //             return true;
            //         }
            //     }
            // }

            // Method 1(better) : direct to dfs
            int xx = x + d[0], yy = y + d[1];
            
            if (isValid(xx, yy) && !visited[xx][yy][i]) {
                visited[xx][yy][i] = true;
                if (dfs(xx, yy, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        
        dest = destination;
        g = maze;
        // check if it's a dead end
        boolean up = isValid(dest[0] - 1, dest[1]);
        boolean down = isValid(dest[0] + 1, dest[1]);
        boolean left = isValid(dest[0], dest[1] - 1);
        boolean right = isValid(dest[0], dest[1] + 1);
        if (up == down && left == right) {
            return false;
        }
        visited = new boolean[m][n][4];
        for (int i = 0; i < 4; i++) {
            visited[start[0]][start[1]][i] = true;
            if (dfs(start[0], start[1], i)) {
                return true;
            }
        }
        return false;
    }
}
// Try to use 4 dir boolean arr, 
// think it over and over again, seems a good idea.
// each poin 4 times max.

// think about this map: s-12345, 
// but 5 will stop at 1, wont go to 1-2 in this method
// **********
// **4     3*
// ** ***** *
// ** **s** *
// **5  1  2*
// *******e**
// **********
// [[0, 0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1, 0], [0, 1, 1, 0, 1, 1, 0], [0, 0, 0, 0, 0, 0, 0], [1, 0, 0, 1, 0, 0, 1]]
// [2, 3]
// [4, 5]
// class Solution {
//     static final int[][] DIR = new int[][] {
//         {0, 1}, {0, -1},
//         {1, 0}, {-1, 0}
//     };

//     int[] dest;
//     int[][] g;
//     boolean[][] visited;
//     int m;
//     int n;
//     boolean isValid(int x, int y) {
//         if (x < 0 || y < 0 || x >= m || y >= n) {
//             return false;
//         }
//         if (g[x][y] == 1) {
//             return false;
//         }
//         return true;
//     }
//     boolean dfs(int x, int y) {
//         if (x == dest[0] && y == dest[1]) {
//             return true;
//         }
//         for (int[] d : DIR) {
//             int xx = x, yy = y;
//             while (isValid(xx + d[0], yy + d[1])) {
//             // while (xx + d[0] < m && xx + d[0] >= 0 && yy + d[1] < n && yy + d[1] >= 0 &&
//             //         g[xx + d[0]][yy + d[1]] == 0) {
//                 xx += d[0];
//                 yy += d[1];
//             }
//             if (!visited[xx][yy]) {
//                 visited[xx][yy] = true;
//                 if (dfs(xx, yy)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//         m = maze.length;
//         n = maze[0].length;
        
//         dest = destination;
//         g = maze;
//         // check if it's a dead end
//         boolean up = isValid(dest[0] - 1, dest[1]);
//         boolean down = isValid(dest[0] + 1, dest[1]);
//         boolean left = isValid(dest[0], dest[1] - 1);
//         boolean right = isValid(dest[0], dest[1] + 1);
//         if (up == down && left == right) {
//             return false;
//         }
//         // if (dest[0] - 1 >= 0 && maze[dest[0] - 1][dest[1]] == 0 && 
//         //     dest[0] + 1 < m  && maze[dest[0] + 1][dest[1]] == 0 && 
//         //     (dest[1] - 1 < 0  || maze[dest[0]][dest[1] - 1] == 1) &&
//         //     (dest[1] + 1 >= n || maze[dest[0]][dest[1] + 1] == 1)) {
//         //         return false;
//         //     }
//         // if (dest[1] - 1 >= 0 && maze[dest[0]][dest[1] - 1] == 0 && 
//         //     dest[1] + 1 < n  && maze[dest[0]][dest[1] + 1] == 0 && 
//         //     (dest[0] - 1 < 0  || maze[dest[0] - 1][dest[1]] == 1) &&
//         //     (dest[0] + 1 >= m || maze[dest[0] + 1][dest[1]] == 1)) {
//         //         return false;
//         //     }
//         visited = new boolean[m][n];
//         visited[start[0]][start[1]] = true;
//         return dfs(start[0], start[1]);
//     }
// }

// simple graph search
