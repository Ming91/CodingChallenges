// LeetCode 75 Graphs - BFS Q1
class Solution {
    static final int[][] DIR = new int[][] {
        {0, 1}, {0, -1},
        {1, 0}, {-1, 0}
    };
    public int nearestExit(char[][] maze, int[] entrance) {
        int steps = 0;
        int m = maze.length;
        int n = maze[0].length;
        if (m == 1 && n == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        // Queue<List<Integer>> q = new LinkedList<>();
        // q.offer(List.of(entrance[0], entrance[1]));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                // List<Integer> curr = q.poll();
                // int x = curr.get(0), y = curr.get(1);
                // if (visited[x][y]) {
                //     continue;
                // }
                // visited[x][y] = true;
                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && 
                    (x != entrance[0] || y != entrance[1])) {
                    return steps;
                }
                for (int[] d : DIR) {
                    int xx = x + d[0], yy = y + d[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || maze[xx][yy] == '+') {
                        continue;
                    }
                    // if (maze[xx][yy] == '+') {
                    //     continue;
                    // }
                    // if (xx == 0 || xx == m - 1 || yy == 0 || yy == n - 1) {
                    //     return steps;
                    // }
                    maze[xx][yy] = '+';
                    q.offer(new int[] {xx, yy});
                    // q.offer(List.of(xx, yy));
                }
            }
            steps++;
        }
        return -1;
    }
}
// beat 99% idea:
//  1.using Queue<int[]> instead of Queue<List<>>
//  2.compare stop condition outside the direction calculation
//  3.just modify the maze rather than new a 'visited' array

// simple bfs
