// Weekly Contest 365 Q4
class Solution {
    void dfs(int curr, List<Integer> edges, int[] ans) {
        
        // Set<Integer> inPath = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        int prev = -1;
        while (ans[curr] == 0) {
            path.add(curr);
            ans[curr] = prev == -1 ? -1 : ans[prev] - 1;
            prev = curr;
            curr = edges.get(curr);
        }
        int idx = path.size() - 1;
        if (ans[curr] < 0) {
            int cycle = ans[curr] - ans[path.get(idx)] + 1;
            int start = ans[curr];
            for (; idx >= 0 && ans[path.get(idx)] <= start; idx--) {
                ans[path.get(idx)] = cycle;
            }
        }
        for (; idx >= 0; idx--) {
            ans[path.get(idx)] = ans[edges.get(path.get(idx))] + 1;
        }
        // Code below works, but ugly. 
        // int tail = prev;
        // int c = ans[curr];
        // int t = ans[tail];
        // if (c > 0) {
        //     for (int node : inPath) {
        //         ans[node] += c - t + 1;
        //     }
        // } else {
        //     int cycle = c - t + 1;
        //     for (int node : inPath) {
        //         if (ans[node] <= c) {
        //             ans[node] = cycle;
        //         } else {
        //             ans[node] = ans[node] - t + 1;
        //         }
        //     }
        // }
    }
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (ans[i] > 0) {
                continue;
            }
            dfs(i, edges, ans);
        }
        return ans;
    }
}
// use two collection to track global visited and curr dfs path visited. 
