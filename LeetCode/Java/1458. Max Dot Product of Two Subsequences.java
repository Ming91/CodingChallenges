// Daily Question 10/08/2023
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int preLeft = Integer.MIN_VALUE;
        int tempLeft = Integer.MIN_VALUE;
        int include = 0, exclude = 0;
        for (int i = 1; i <= m; i++) {
            preLeft = Integer.MIN_VALUE;
            for (int j = 1; j <= n; j++) {
                tempLeft = preLeft;
                preLeft = dp[j];
                exclude = Math.max(dp[j - 1], dp[j]);
                include = Math.max(0, tempLeft) + nums1[i - 1] * nums2[j - 1];
                dp[j] = Math.max(exclude, include);
            }
        }
        return dp[n];
    }
}
// [Beat 99%]
//  1D impl with 1-index.
//  1. 1-index omit lots of check.
//  2. use temp var to have less (nested) Math.max. 

// [Ming] 1D impl with 0-index
// class Solution {
//     public int maxDotProduct(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         int[] dp = new int[n];
//         int preLeft = Integer.MIN_VALUE;
//         int preUp = Integer.MIN_VALUE;
//         int tempLeft = Integer.MIN_VALUE;
//         for (int i = 0; i < m; i++) {
//             preLeft = Integer.MIN_VALUE;
//             for (int j = 0; j < n; j++) {
//                 preUp = i == 0 ? Integer.MIN_VALUE : dp[j];
//                 tempLeft = preLeft;
//                 preLeft = i == 0 ? Integer.MIN_VALUE : dp[j];
//                 dp[j] = nums1[i] * nums2[j];
//                 if (i > 0) {
//                     dp[j] = Math.max(dp[j], preUp);
//                 }
//                 if (j > 0) {
//                     dp[j] = Math.max(dp[j], dp[j - 1]);
//                 }
//                 if (i > 0 && j > 0) {
//                     dp[j] = Math.max(dp[j], tempLeft + nums1[i] * nums2[j]);
//                 }
//             }
//         }
//         return dp[n - 1];
//     }
// }
// [Ming] 2D impl with 0-index
// class Solution {
//     public int maxDotProduct(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 dp[i][j] = nums1[i] * nums2[j];
//                 if (i > 0) {
//                     dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
//                 }
//                 if (j > 0) {
//                     dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
//                 }
//                 if (i > 0 && j > 0) {
//                     dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
//                 }
//             }
//         }
//         return dp[m - 1][n - 1];
//     }
// }
// [Ming] 2D impl with 1-index
// class Solution {
//     public int maxDotProduct(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i <= m; i++) {
//             dp[i][0] = Integer.MIN_VALUE;
//         }
//         for (int j = 0; j <= n; j++) {
//             dp[0][j] = Integer.MIN_VALUE;
//         }
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 dp[i][j] = nums1[i - 1] * nums2[j - 1];
//                 dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
//                 dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
//                 if (dp[i - 1][j - 1] != Integer.MIN_VALUE) {
//                     dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }
