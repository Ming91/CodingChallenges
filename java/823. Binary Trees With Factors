// Daily Question 10/26/2023
class Solution {
    static final int MOD = 1_000_000_007;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        dp.put(arr[0], 1L);
        long ans = 1;
        int l = 0;
        int r = 0;
        int bound = 0;
        long res = 0;
        for (int i = 1; i < n; i++) {
            bound = (int)Math.sqrt(arr[i]);
            res = 0;
            for (int j = 0; arr[j] <= bound; j++) {
                l = arr[j];
                r = arr[i] / arr[j];
                if (l * r != arr[i] || !dp.containsKey(r)) {
                    continue;
                }
                if (l == r) {
                    res = (res + (dp.get(l) * dp.get(l)) % MOD) % MOD;
                } else {
                    res = (res + (dp.get(l) * dp.get(r) * 2) % MOD) % MOD;
                }
            }
            res++;
            dp.put(arr[i], res);
            ans = (ans + res) % MOD;
        }
        return (int)ans;
    }
}
// [Beat 99%]
//  iterate from arr[0] to arr[j]<= sqrt(arr[i]),
//  if k==l, dp[v] += dp[k]^2
//  or, dp[v] += dp[k] * dp[l] * 2, since swapping left and right child will have a new tree.

// [Editorial]
//  [Failed] I didn't solve this. 
//  dp[v] += dp[k] * dp[l] if v = k*l;
//  A better 

// [Editorial] normal version
// class Solution {
//     static final int MOD = 1_000_000_007;
//     public int numFactoredBinaryTrees(int[] arr) {
//         int n = arr.length;
//         long[] dp = new long[n];
//         Arrays.sort(arr);
//         Map<Integer, Integer> numToIdx = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             numToIdx.put(arr[i], i);
//         }
//         int temp = 0;
//         dp[0] = 1;
//         long ans = 1;
//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 temp = arr[i] / arr[j];
//                 if (temp * arr[j] != arr[i] || !numToIdx.containsKey(temp)) {
//                     continue;
//                 }
//                 dp[i] += (dp[j] * dp[numToIdx.get(temp)]) % MOD;
//                 dp[i] %= MOD;
//             }
//             dp[i]++;
//             ans = (ans + dp[i]) % MOD;
//         }
//         return (int)ans;
//     }
// }
