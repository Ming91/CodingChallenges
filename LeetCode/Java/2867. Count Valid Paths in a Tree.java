// Weekly Contest 364 Q4
class Solution {
    boolean[] isPrime;
    List<List<Integer>> adj;
    long ans;
    long mul(long[] x, long[] y) {
        return x[0] * y[1] + x[1] * y[0];
    }
    void dfs(int curr, int parent, long[][] dp) {
        dp[curr][1] = isPrime[curr] ? 1 : 0;
        dp[curr][0] = 1 - dp[curr][1];
        for (int next : adj.get(curr)) {
            if (next == parent) {
                continue;
            }
            dfs(next, curr, dp);
            ans += mul(dp[curr], dp[next]);
            if (isPrime[curr]) {
                dp[curr][1] += dp[next][0];
            } else {
                dp[curr][0] += dp[next][0];
                dp[curr][1] += dp[next][1];
            }
        }
        
    }
    public long countPaths(int n, int[][] edges) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            int comp = i << 1;
            while (comp <= n) {
                isPrime[comp] = false;
                comp += i;
            }
        }
        // System.out.println(Arrays.toString(isPrime));
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        long[][] dp = new long[n + 1][2];
        ans = 0;
        dfs(1, 0, dp);
        return ans;
    }
}
// [Solutions] cpcs
//  Very clever way to count ans. 
//  dp[curr][0] is the paths start from curr with no prime
//  dp[curr][1] is the paths start from curr with 1 prime
//  if curr is prime, [0] = 0, [1] = 1, o/w [0] = 1, [1] = 0. 
//  so [curr][0] * [child][1] + [curr][1] * [child][1] is 
//  the number of valid combinations of paths start from curr (to previous subtrees) and start from child. 
//  Update [curr] with [child] after multiply. 
//  very very clever way. 
