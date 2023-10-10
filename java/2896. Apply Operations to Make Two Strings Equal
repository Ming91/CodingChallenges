// Weekly Contest 366 Q3
class Solution {
    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        int inf = 50_000;
        int one = inf, two = inf, last = inf;
        int done = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                one = Math.min(one, last);
                last = last + 1;
                two = two + 1;
                continue;
            }
            if (done < n) {
                one = Math.min(two + 1, done + x);
                last = Math.min(two + x, done);
                done = two = inf;
                continue;
            }
            done = Math.min(one + x, last + 1);
            two = one;
            one = last = inf;
            continue;
        }
        return done == inf ? -1 : done;
    }
}
// [Lee]
//  Use one, two, last, done to record state. 
//  Lee use one as any prefix has 1, here I use one as prefix has 1 and exclude `last` situation. 

// class Solution {
//     int x;
//     int calc(int[][] dp, int i, int j, List<Integer> diffIdx) {
//         if (i >= j) {
//             return 0;
//         }
//         if (dp[i][j] != 0) {
//             return dp[i][j];
//         }
//         int res = Math.min(diffIdx.get(j) - diffIdx.get(i), x) + calc(dp, i + 1, j - 1, diffIdx);
//         for (int k = i + 1; k < j; k += 2) {
//             res = Math.min(res, Math.min(diffIdx.get(k) - diffIdx.get(i), x) + calc(dp, i + 1, k - 1, diffIdx) + calc(dp, k + 1, j, diffIdx));
//         }
//         dp[i][j] = res;
//         return res;
//     }
//     public int minOperations(String s1, String s2, int x) {
//         List<Integer> diffIdx = new ArrayList<>();
//         int n = s1.length();
//         this.x = x;
//         for (int i = 0; i < n; i++) {
//             if (s1.charAt(i) != s2.charAt(i)) {
//                 diffIdx.add(i);
//             }
//         }
//         if ((diffIdx.size() & 1) == 1) {
//             return -1;
//         }
//         int m = diffIdx.size();
//         int[][] dp = new int[m][m];
//         return calc(dp, 0, m - 1, diffIdx);
//     }

// }
