// Weekly Contest 357 Q3
class Solution {
    static final int[][] DIR = {
        {+1, 0}, {-1, 0},
        {0, +1}, {0, -1}
    };
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // calc dist 
        Queue<List<Integer>> q = new LinkedList<>();
        // int[][] dist = new int[n][n];
        int[][] ans = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(List.of(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int len = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int ii = 0; ii < size; ii++) {
                List<Integer> curr = q.poll();
                for (int d = 0; d < 4; d++) {
                    int i = curr.get(0) + DIR[d][0];
                    int j = curr.get(1) + DIR[d][1];
                    if (i >= n || i < 0 || j >=n || j < 0 || visited[i][j]) {
                        continue;
                    }
                    ans[i][j] = len;
                    // dist[i][j] = len;
                    visited[i][j] = true;
                    q.offer(List.of(i, j));
                }
            }
            len++;
        }
        
        // System.out.println(Arrays.deepToString(dist));

        // dijkstra to calc answer

        // This is wrong, found it in problem 1631. Path With Minimum Effort
        // If (a,b) added to the queue before, and added again with a smaller value later. 
        // The later added (a,b) may be compared with the old (a, b) in the heap. 
        // Even though (a, b) may have a smaller dist[][] value than its parent, 
        // but dist[a][b] = dist[a][b] will stop it from continuing to compare and swap. So the queue is not maintained.
        
        // eg. (1, 1, 2) - (2, 2, 3), then (2, 2, 1) added, then dist[2][2] == dist[2][2] will stop (2, 2) compare to (1, 1).
        
        // Queue<List<Integer>> p = new PriorityQueue<>(
        //     (l1, l2) -> (ans[l2.get(0)][l2.get(1)] - ans[l1.get(0)][l1.get(1)])
        // );
        Queue<List<Integer>> p = new PriorityQueue<>(
            (l1, l2) -> (l2.get(2) - l1.get(2))
        );
        
        p.offer(List.of(0, 0));
        // ans[0][0] = dist[0][0];
        while (!p.isEmpty()) {
            List<Integer> curr = p.poll();
            int ii = curr.get(0);
            int jj = curr.get(1);
            if (ii == n - 1 && jj == n - 1) {
                return ans[ii][jj];
            }
            if (!visited[ii][jj]) {
                continue;
            }
            // ans[ii][jj] = Math.min(dist[ii][jj], Math.max(ans[ii][jj], ans[ii][jj]));
            visited[ii][jj] = false;            
            for (int d = 0; d < 4; d++) {
                int i = ii + DIR[d][0];
                int j = jj + DIR[d][1];
                if (i >= n || i < 0 || j >=n || j < 0 || !visited[i][j]) {
                    continue;
                }
                ans[i][j] = Math.min(ans[i][j], ans[ii][jj]);
                p.offer(List.of(i, j, ans[i][j]));
            }
            // ans[ii][jj] = 0;
            
        }
        return 0;
    }
}
// 想法: 用扩散的方法在n^2求出所有点到theif的距离
//       方法1: 用二分搜索, 对于每个备选距离d, 用bfs看看有没有路径
//       方法2: 用最短路, 优先队列在备选里选距离最大的, 更新时存路径上最小的距离, 直到n-1,n-1出队列
