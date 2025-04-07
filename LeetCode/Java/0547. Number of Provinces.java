// LeetCode 75 Graphs - DFS Q2
class Solution {
    int n;
    int size;
    int ans;
    boolean[] visited;
    int[][] grid;
    void dfs(int curr) {
        
        visited[curr] = true;
        // size++;
        // if (size == n) {
        //     return ;
        // }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue ;
            }
            if (grid[curr][i] == 1) {
                dfs(i);
            }
        }
        return ;
    }
    public int findCircleNum(int[][] isConnected) {
        grid = isConnected;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        n = isConnected.length;
        visited = new boolean[n];
        size = 0;
        ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            ans++;
            dfs(i);
            // if (size == n) {
            //     return ans;
            // }
        }
        return ans;
    }
}
// 挨个dfs, 记录是否访问过
// 少点early stop判断, 反而更快..

// 写个并查集, 练手
// rank没有实现, 应该在union时比较, 小的并到大的上面
// class Solution {
//     class UnionFind {
//         int[] parent;
//         int[] rank;
//         UnionFind(int n) {
//             parent = new int[n];
//             rank = new int[n];
//             for (int i = 0; i < n; i++) {
//                 parent[i] = i;
//             }
//         }
//         int find(int x) {
//             while (parent[x] != x) {
//                 x = parent[x];
//             }
//             return x;
//         }
//         void union(int x, int y) {
//             int px = find(x), py = find(y);
//             if (px == py) {
//                 return ;
//             }
//             parent[px] = py;
//             return ;
//         }
//     }
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         UnionFind u = new UnionFind(n);
//         int ans = n;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (isConnected[i][j] == 1 && u.find(i) != u.find(j)) {
//                     ans--;
//                     u.union(i, j);
//                 }
//             }
//         }
//         return ans;
//     }
// }
