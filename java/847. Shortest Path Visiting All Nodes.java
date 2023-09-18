// Daily Question 09/17/2023
class Solution {
    // int[][] dp;
    int dfs(int[][] graph, int curr, int bitMap, int[][] dp) {
        if (dp[curr][bitMap] != 0) {
            return dp[curr][bitMap];
        }
        // come to the last node
        if ((bitMap & (bitMap - 1)) == 0) {
            return 0;
        }
        dp[curr][bitMap] = Integer.MAX_VALUE - 1;
        int result = Integer.MAX_VALUE - 1;
        for (int neighbor : graph[curr]) {
            // just backtrack visited neighbor as precedent
            if ((bitMap & (1 << neighbor)) != 0) {
                int visitedCurr = dfs(graph, neighbor, bitMap, dp);

                // we only visit neighbor that in the bitMap, so curr also in bitMap
                // following map convert all works
                // 0 1 -> 0, 1 1 -> 0
                // int notVisitedCurr = dfs(graph, neighbor, bitMap & ~(1 << curr), dp);
                // 0 1 -> 1 (not possible in this case), 1 1 -> 0
                int notVisitedCurr = dfs(graph, neighbor, bitMap ^ (1 << curr), dp);

                int temp = Math.min(visitedCurr, notVisitedCurr);
                result = Math.min(result, temp);
                // dp[curr][bitMap] = Math.min(1 + temp, dp[curr][bitMap]);
            }
        }
        dp[curr][bitMap] = Math.min(1 + result, dp[curr][bitMap]);
        return dp[curr][bitMap];
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int endMap = (1 << n) - 1;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][endMap + 1];
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dfs(graph, i, endMap, dp));
        }
        return ans;
    }
}
