// Weekly Contest 369 Q4
class Solution {
    // List<Integer>[] next;
    int[] end;
    int[] head;
    int[] next;
    int[] coins;
    int k;
    int index;
    void add(int u, int v) {
        end[index] = v;
        next[index] = head[u];
        head[u] = index++;
    }
    int[] calcDP(int curr, int parent, int depth) {
        depth = Math.min(depth, 13);
        int[] res = new int[depth + 2];
        int e = head[curr];
        while (e != -1) {
            int child = end[e];
            e = next[e];
            if (child == parent) {
                continue;
            }
            int[] childRes = calcDP(child, curr, depth + 1);
            for (int i = 0; i < 14 && i <= depth + 1; i++) {
                res[i] += childRes[i];
            }
        }
        int[] ans = new int[depth + 1];
        for (int i = 0; i <= depth; i++) {
            ans[i] = Math.max(res[i] - k + (coins[curr] >> i), res[i + 1] + (coins[curr] >> (i + 1)));
        }
        return ans;
    }
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        this.coins = coins;
        this.k = k;
        int m = edges.length;
        index = 0;
        // end = new int[m];
        // next = new int[m];
        // head = new int[n];
        // This is a tree, not a graph, we can use less space.
        end = new int[n << 1];
        next = new int[n << 1];
        head = new int[n];
        Arrays.fill(head, -1);
        for (int[] e : edges) {
            add(e[0], e[1]);
            add(e[1], e[0]);
        }
        return calcDP(0, -1, 0)[0];
    }
}
// [Beat 99%]
//  "forward star" representation:
//     void add(int u, int v) {
//         end[index] = v;
//         next[index] = head[u];
//         head[u] = index++;
//     }
//  use head[V] end[E] next[E] to present the adjecent list. 

//  The idea is, get all the 14 depths result of each node at the same time. 
//  Since this can be done by adding all children points. 
//  So we will visit each node only once.
//  (The original dp visit same node much more times but calculate each depth for once)

// [Lee] 
//  @vortrubac
//     if (vis[i] > v) return 0;
//     vis[i]++;
//  This is idea can also effect the my `formal` versin DP,
//  We need to see that in these methods, we go the same depth first, then diverge to depth+1,
//  So vis[i] means the time that curr node is visited, and indeed the depthest level that 
//   this node can reach (since shallower visit has blocked). 
//  Why we return 0 if this [curr][depth] is visited?
//  Think of this `Pascal Triangle`, the depth change in the tree follows this pattern. 
//  If [curr][depth] is visit, the first visit is from [parent][depth-1], then from [parent][depth]. 
//  So, if we chose a branch in this `decision tree`, we chose when to increase depth/chose option 2.
//  And in this problem, if a branch has chose option 2 L times/ the leaf has L-depth, we want these 
//  changes go as late as possible. eg. if we reach 1 in the end, 0-0-0-0-1 is better than
//  0-1-1-1-1. I haven't prove this, but the pattern is so.
//     0
//    0 1
//   0 1 2
//  0 1 2 3
// 0 1 2 3 4
//  Another example: parent a coins, child b coins,
//  options     1       2
//  a          a-k      a/2
//  options   1   2    1        2
//  b        b-k  b/2  b/2-k    b/4
//  We can see max(b-k, b/2) is always better than max(b/2-k, b/4). 
//  But in real case, we need to consider b's brothers and childs. 

// class Solution {
//     List<Integer>[] G;
//     int[] vis;
//     int dfs(int i, int p, int[] A, int k, int v) {
//         if (v > 13) return 0;
//         if (vis[i] > v) return 0;
//         vis[i]++;
//         int op1 = (A[i] >> v) - k, op2 = A[i] >> v + 1;
//         for (int j : G[i]) {
//             if (j == p) continue;
//             op1 += dfs(j, i, A, k, v);
//             op2 += dfs(j, i, A, k, v + 1);
//         }
//         return Math.max(op1, op2);
//     }

//     int maximumPoints(int[][] edges, int[] A, int k) {
//         int n = edges.length + 1;
//         G = new List[n];
//         vis = new int[n];
//         for (int i = 0; i < n; i++) {
//             G[i] = new ArrayList();
//         }
//         for (int[] e : edges) {
//             G[e[0]].add(e[1]);
//             G[e[1]].add(e[0]);
//         }
//         return dfs(0, -1, A, k, 0);
//     }
// }

// [Ming][Failed]
//  I didn't solve this in the contest, 
//  After that I use the wrong formula for option 1, which is (coins - k) >> depth. 
// class Solution {
//     List<Integer>[] next;
//     Integer[][] dp;
//     int[] coins;
//     int k;
//     int calcDP(int curr, int parent, int depth) {
//         if (depth >= 14) {
//             return 0;
//         }
//         if (dp[curr][depth] != null) {
//             // [Lee] a special point of view. 
//             return 0;
//             // return dp[curr][depth];
//         }
//         int res1 = (coins[curr] >> depth) - k;
//         // [WTF] totally wrong, shift before subtract!
//         // int res1 = 0;
//         // if (coins[curr] >= k) {
//         //     res1 = (coins[curr] - k) >> depth;
//         // } else {
//         //     res1 = (k - coins[curr]) >> depth;
//         //     res1 = -res1;
//         // }
//         int res2 = coins[curr] >> (depth + 1);
//         for (int child : next[curr]) {
//             if (child == parent) {
//                 continue;
//             }
//             res1 += calcDP(child, curr, depth);
//             res2 += calcDP(child, curr, depth + 1);
//         }
//         dp[curr][depth] = Math.max(res1, res2);
//         // System.out.println(curr + "," + depth + ":" + dp[curr][depth]);
//         return dp[curr][depth];
//     }
//     public int maximumPoints(int[][] edges, int[] coins, int k) {
//         int n = coins.length;
//         this.coins = coins;
//         this.k = k;
//         next = new ArrayList[n];
//         dp = new Integer[n][14];
//         for (int i = 0; i < n; i++) {
//             next[i] = new ArrayList<>();
//         }
//         for (int[] e : edges) {
//             next[e[0]].add(e[1]);
//             next[e[1]].add(e[0]);
//         }
//         calcDP(0, -1, 0);
//         System.out.println(Arrays.deepToString(dp));
//         return dp[0][0];
// //        return Math.max(dp[0][0], dp[0][1]);
//     }
// }
