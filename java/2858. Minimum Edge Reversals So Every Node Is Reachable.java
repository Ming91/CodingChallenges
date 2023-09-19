// Biweekly Contest 113 Q4
class Solution {
    Map<Integer, List<Integer>> adjList;
    int[] ans;

    int dfs1(int parent, int curr) {
        int cost = 0;
        for (int nextValue : adjList.get(curr)) {
            int next = Math.abs(nextValue);
            if (next == parent) {
                continue;
            }
            cost += dfs1(curr, next);
            if (nextValue < 0) {
                cost++;
            }
        }
        return cost;
    }

    void dfs2(int parent, int curr) {
        for (int nextValue : adjList.get(curr)) {
            int next = Math.abs(nextValue);
            if (next == parent) {
                continue;
            }
            ans[next] = ans[curr];
            ans[next] += nextValue > 0 ? 1 : -1;
            dfs2(curr, next);
        }
    }

    public int[] minEdgeReversals(int n, int[][] edges) {
        adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
            adjList.computeIfAbsent(to, x -> new ArrayList<>()).add(-from);
        }
        ans = new int[n];
        ans[0] = dfs1(-1, 0);
        dfs2(-1, 0);
        return ans;
    }
}
// [Ming] Impl after Lee's Solution
//  use dfs(parent, curr) to save a visited array.

// [Ming] Naive Impl
// class Solution {
//     void dfs(Map<Integer, List<Integer>> adjList, int[] subtreeCost, boolean[] visited, int curr) {
//         int cost = 0;
//         visited[curr] = true;
//         for (int neighbor : adjList.get(curr)) {
//             int ngb = Math.abs(neighbor);
//             if (!visited[ngb]) {
//                 dfs(adjList, subtreeCost, visited, ngb);
//                 cost += subtreeCost[ngb];
//                 cost += neighbor > 0 ? 0 : 1;
//             }
//         }
//         subtreeCost[curr] = cost;
//     }
//     void dfs2(Map<Integer, List<Integer>> adjList, boolean[] visited, int[] ans, int curr) {
//         visited[curr] = true;
//         for (int neighbor : adjList.get(curr)) {
//             int ngb = Math.abs(neighbor);
//             if (!visited[ngb]) {
//                 if (neighbor > 0) {
//                     ans[ngb] = ans[curr] + 1;
//                 } else {
//                     ans[ngb] = ans[curr] - 1;
//                 }
//                 dfs2(adjList, visited, ans, ngb);
//             }
//         }
//     }
//     public int[] minEdgeReversals(int n, int[][] edges) {
//         Map<Integer, List<Integer>> adjList = new HashMap<>();
//         // int[] rootDir = new int[n];
//         for (int[] edge : edges) {
//             int from = edge[0];
//             int to = edge[1];
//             if (!adjList.containsKey(from)) {
//                 adjList.put(from, new ArrayList<>());
//             }
//             if (!adjList.containsKey(to)) {
//                 adjList.put(to, new ArrayList<>());
//             }
//             adjList.get(from).add(to);
//             adjList.get(to).add(-from);
//             // if (from == 0) {
//             //     rootDir[to] = 1;
//             // }
//             // if (to == 0) {
//             //     rootDir[from] = -1;
//             // }
//         }
//         int[] subtreeCost = new int[n];
//         boolean[] visited = new boolean[n];
//         dfs(adjList, subtreeCost, visited, 0);
//         // System.out.println(Arrays.toString(rootDir));
//         // System.out.println(Arrays.toString(subtree7Cost));
//         visited = new boolean[n];
//         int[] ans = new int[n];
//         ans[0] = subtreeCost[0];
//         dfs2(adjList, visited, ans, 0);

//         return ans;
//     }
// }
