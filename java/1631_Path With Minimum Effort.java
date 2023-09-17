// Daily Question 09/16/2023
// class Solution {
//     static final int[][] DIR = {{+1, 0}, {-1, 0}, {0, +1}, {0, -1}
//             // {0, 1}, {1, 0}, {0, -1}, {-1, 0}
//     };
//     int m;
//     int n;

//     boolean isValid(int[][] heights, int bound, boolean[][] visited, int i, int j) {
//         if (i == m - 1 && j == n - 1) {
//             return true;
//         }
//         visited[i][j] = true;
//         boolean ans = false;
//         for (int d = 0; d < 4; d++) {
//             int ii = i + DIR[d][0];
//             int jj = j + DIR[d][1];
//             if (ii >= m || ii < 0 || jj >= n || jj < 0 || visited[ii][jj]) {
//                 continue;
//             }
//             int effort = Math.abs(heights[ii][jj] - heights[i][j]);
//             // key part, treat it carefully 
//             if (effort <= bound) {
//                 ans |= isValid(heights, bound, visited, ii, jj);
//             }
//             if (ans) {
//                 return true;
//             }
//         }
//         return ans;
//     }

//     public int minimumEffortPath(int[][] heights) {
//         m = heights.length;
//         n = heights[0].length;
//         int l = 0;
//         int r = 1_000_000;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             boolean[][] visited = new boolean[m][n];
//             if (!isValid(heights, mid, visited, 0, 0)) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
// }
// [Editorial] 
//  Binary Search with DFS O（mn）, but runs slower.
//  ** Can go to the destination from any path. So, if any direction of the four is true, return true.

// [Ming] Impl Dijkstra using priority queue. O(mn log(mn)). Base on 2812_Find the Safest Path in a Grid.
//  ** The queue should store the dist value, if use dist[][] in the comparator will cause error.

// If (a,b) added to the queue before, and added again with a smaller value later. 
// The later added (a,b) may be compared with the old (a, b) in the heap. 
// Even though (a, b) may have a smaller dist[][] value than its parent, 
// but dist[a][b] = dist[a][b] will stop it from continuing to compare and swap. So the queue is not maintained.

// eg. (1, 1, 2) - (2, 2, 3), then (2, 2, 1) added, then dist[2][2] == dist[2][2] will stop (2, 2) compare to (1, 1).

class Solution {
    static final int[][] DIR = {
            { +1, 0 }, { -1, 0 },
            { 0, +1 }, { 0, -1 }
            // {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        Queue<int[]> p = new PriorityQueue<>(
                (a, b) -> (a[2] - b[2]));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        p.offer(new int[] { 0, 0, 0 });
        // int ans = Integer.MAX_VALUE;
        while (!p.isEmpty()) {
            int[] curr = p.poll();
            int i = curr[0];
            int j = curr[1];
            if (i == m - 1 && j == n - 1) {
                return dist[i][j];
            }
            if (visited[i][j]) {
                continue;
            }
            // System.out.print(i + "," + j + "  ");
            visited[i][j] = true;
            for (int d = 0; d < 4; d++) {
                int ii = i + DIR[d][0];
                int jj = j + DIR[d][1];
                if (ii >= m || ii < 0 || jj >= n || jj < 0 || visited[ii][jj]) {
                    continue;
                }
                int effort = Math.abs(heights[ii][jj] - heights[i][j]);
                int update = Math.max(dist[i][j], effort);
                if (update < dist[ii][jj]) {
                    dist[ii][jj] = update;
                    p.offer(new int[] { ii, jj, update });
                }
            }
            // ans[ii][jj] = 0;

        }
        return 0;
    }
}
