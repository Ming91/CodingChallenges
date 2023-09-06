// Daily Challenge 08/27/2023
class Solution {
    int n;
    boolean[][] dp;
    boolean dfs(int[] stones, int prev, int curr) {
        if (curr == n - 1) {
            return true;
        }
        if (dp[prev][curr]) {
            return false;
        }
        boolean res = false;
        int step = stones[curr] - stones[prev];
        int next = curr + 1;
        int nextStep = stones[next] - stones[curr];
        while (next < n && stones[next] - stones[curr] <= step + 1) {
            if (stones[next] - stones[curr] >= step - 1) {
                if (dfs(stones, curr, next)) {
                    return true;
                }
            }
            next++;
        }
        dp[prev][curr] = true;
        return false;
    }
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        n = stones.length;
        // inverse dp, since dp init with false
        dp = new boolean[n][n];
        return dfs(stones, 0, 1);
    }
}

// class Solution {
//     public boolean canCross(int[] stones) {
//         int n = stones.length;
//         boolean[][] dp = new boolean[n][n + 1];
//         Map<Integer, Integer> stoneToIdx = new HashMap<>();
//         dp[0][0] = true;
//         for (int i = 0; i < n; i++) {
//             stoneToIdx.put(stones[i], i);
//         }
//         for (int i = 0; i < n; i++) {
//             for (int step = 0; step < n; step++) {
//                 if (dp[i][step]) {
//                     for (int j = step - 1; j <= step + 1; j++) {
//                         if (stoneToIdx.containsKey(stones[i] + j)) {
//                             int next = stoneToIdx.get(stones[i] + j);
//                             dp[next][j] = true;
//                         }
//                     }
//                 }
//             }
//         }
//         for (int step = 1; step < n; step++) {
//             if (dp[n - 1][step]) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
