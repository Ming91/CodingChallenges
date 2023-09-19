// Weekly Premium Sep 2023 W3
class Solution {
    int dfs(List<Integer>[] adjList, int[] longest, int curr) {
        if (longest[curr] != 0) {
            return longest[curr];
        }
        longest[curr] = -1;
        int res = 0;
        if (adjList[curr] == null) {
            longest[curr] = 1;
            return longest[curr];
        }
        for (int next : adjList[curr]) {
            int len = dfs(adjList, longest, next);
            if (len == -1) {
                return -1;
            }
            res = Math.max(res, len);
        }
        longest[curr] = res + 1;
        return longest[curr];
    }

    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int[] relation : relations) {
            int from = relation[0];
            int to = relation[1];
            if (adjList[from] == null) {
                adjList[from] = new ArrayList<>();
            }
            adjList[from].add(to);
        }
        int[] longest = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int curr = dfs(adjList, longest, i);
            if (curr == -1) {
                return -1;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
// [Editorial] Just ask the length, can use dfs.
//  Detect Loop is needed.

// [Ming] Topological Sort using BFS with queue. AKA, Kahn's Algo
// class Solution {
//     public int minimumSemesters(int n, int[][] relations) {
//         List<Integer>[] adjList = new ArrayList[n + 1];
//         int[] inDegree = new int[n + 1];
//         for (int[] relation : relations) {
//             int from = relation[0];
//             int to = relation[1];
//             if (adjList[from] == null) {
//                 adjList[from] = new ArrayList<>();
//             }
//             adjList[from].add(to);
//             inDegree[to]++;
//         }
//         Queue<Integer> q = new LinkedList<>();
//         int visited = 0;
//         for (int i = 1; i <= n; i++) {
//             if (inDegree[i] == 0) {
//                 visited++;
//                 q.add(i);
//             }
//         }
//         int ans = 0;
//         while (!q.isEmpty()) {
//             int size = q.size();
//             int count = 0;
//             while (count < size) {
//                 int from = q.poll();
//                 if (adjList[from] == null) {
//                     count++;
//                     continue;
//                 }
//                 for (int to : adjList[from]) {
//                     inDegree[to]--;
//                     if (inDegree[to] == 0) {
//                         visited++;
//                         q.add(to);
//                     }
//                 }
//                 count++;
//             }
//             ans++;
//         }
//         return visited == n ? ans : -1;
//     }
// }
