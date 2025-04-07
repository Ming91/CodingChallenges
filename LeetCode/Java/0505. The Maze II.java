// Weekly Premium Oct 2023 W2
class Solution {
    static final int[] DIR = new int[] {0, 1, 0, -1, 0};
    int m, n;
    int[][] maze;
    boolean isValid(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == 1) {
            return false;
        }
        return true;
    }
    public int shortestDistance(int[][] maze, int[] start, int[] end) {
        m = maze.length;
        n = maze[0].length;
        this.maze = maze;
        boolean up = isValid(end[0] - 1, end[1]);
        boolean down = isValid(end[0] + 1, end[1]);
        boolean left = isValid(end[0], end[1] - 1);
        boolean right = isValid(end[0], end[1] + 1);
        if (up == down && left == right) {
            return -1;
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] distance = new int[m][n];
        distance[start[0]][start[1]] = 1;
        q.add(new int[] {start[0], start[1], 1});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            // Seems meaningless. 
            // But it's not! Think of we add (x, y, 3) and (x, y, 2) in the queue.
            //  After we process (x, y, 2) and then visit (x, y, 3), there is no need to reprocess. 
            //  Since (x, y) is added to the visited set. 
            if (distance[x][y] < curr[2]) {
                continue;
            }
            // This is the right place to check end. 
            if (x == end[0] && y == end[1]) {
                return distance[x][y] - 1; 
            }
            for (int d = 0; d < 4; d++) {
                int xx = x;
                int yy = y;
                int dist = 0;
                while (isValid(xx + DIR[d], yy + DIR[d + 1])) {
                    xx += DIR[d];
                    yy += DIR[d + 1];
                    dist++;
                }
                if (distance[xx][yy] == 0 || distance[xx][yy] > distance[x][y] + dist) {
                    distance[xx][yy] = distance[x][y] + dist;
                    // This is wrong, may update better result later. 
                    // if (xx == end[0] && yy == end[1]) {
                    //     return distance[xx][yy] - 1; 
                    // }
                    q.offer(new int[] {xx, yy, distance[xx][yy]});
                }
            }
        }
        return distance[end[0]][end[1]] - 1;
    }
}
// [Editorial] 
//  Dijkstra, ordered by distance in priority queue. 
//  Not the original version of Dijkstra, which is selecting closest remain. ×
//  After add the stopping condition, this is the right Dijkstra. 

// [Ming] BFS solution. (Use bfs because misread the problem. Thought distance is the number of stops.)
// class Solution {
//     static final int[] DIR = new int[] {0, 1, 0, -1, 0};
//     int m, n;
//     int[][] maze;
//     boolean isValid(int x, int y) {
//         if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == 1) {
//             return false;
//         }
//         return true;
//     }
//     public int shortestDistance(int[][] maze, int[] start, int[] end) {
//         m = maze.length;
//         n = maze[0].length;
//         this.maze = maze;
//         boolean up = isValid(end[0] - 1, end[1]);
//         boolean down = isValid(end[0] + 1, end[1]);
//         boolean left = isValid(end[0], end[1] - 1);
//         boolean right = isValid(end[0], end[1] + 1);
//         if (up == down && left == right) {
//             return -1;
//         }
//         int ans = 1;
//         Queue<int[]> q = new LinkedList<>();
//         int[][] distance = new int[m][n];
//         distance[start[0]][start[1]] = 1;
//         q.add(start);
//         while (!q.isEmpty()) {
//             int[] curr = q.poll();
//             int x = curr[0], y = curr[1];
//             for (int d = 0; d < 4; d++) {
//                 int xx = x;
//                 int yy = y;
//                 int dist = 0;
//                 while (isValid(xx + DIR[d], yy + DIR[d + 1])) {
//                     xx += DIR[d];
//                     yy += DIR[d + 1];
//                     dist++;
//                 }
//                 if (distance[xx][yy] == 0 || distance[xx][yy] > distance[x][y] + dist) {
//                     distance[xx][yy] = distance[x][y] + dist;
//                     q.offer(new int[] {xx, yy});
//                 }
//             }
//         }
//         return distance[end[0]][end[1]] - 1;
//     }
// }
