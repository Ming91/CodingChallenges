// LeetCode 75 Graphs - BFS Q2
class Solution {
    static final int[][] DIR = new int[][] {
        {0, 1}, {0, -1},
        {1, 0}, {-1, 0}
    };

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                    continue;
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int minutes = 1;
        while (!q.isEmpty() && count > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                for (int[] d : DIR) {
                    int xx = x + d[0], yy = y + d[1];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 1) {
                        count--;
                        grid[xx][yy] = 2;
                        q.offer(new int[] {xx, yy});
                        
                    }
                
                }
                if (count == 0) {
                    return minutes;
                }
            }
            
            minutes++;
        }
        return count == 0 ? 0 : -1;
    }
}
// simple bfs
//  remember to count fresh oranges to check if all become rotten
