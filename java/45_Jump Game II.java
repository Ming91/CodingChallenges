// Top Interview 150 Q10
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, ans = 0, farest = 0;
        // i < n, so can deal with [0] case
        for (int i = 0; i < n - 1; i++) {
            farest = Math.max(farest, i + nums[i]);
            if (farest >= n - 1) {
                return ans + 1;
            }
            if (i == end) {
                end = farest;
                ans++;
            }
        }
        return ans;
    }
}

// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         dp[0] = 1;
//         for (int i = 0; i < n; i++) {
//             if (dp[i] < 0) {
//                 continue;
//             }
//             for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
//                 if (dp[j] == 0) {
//                     dp[j] = dp[i] + 1;
//                 } else {
//                     dp[j] = Math.min(dp[j], dp[i] + 1);
//                 }
//             }
//         }
//         return dp[n - 1] - 1;
//     }
// }
