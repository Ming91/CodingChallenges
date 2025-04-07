// Top Interview 150 Array / String Q9
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int leftMost = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            int curr = nums[i] + i;
            if (curr >= leftMost) {
                leftMost = i;
            }
        }
        return leftMost == 0;
    }
}
// ugly sim
// class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         if (n == 1) {
//             return true;
//         }
//         int i = n - 1;
//         while (i >= 0) {
//             if (nums[i] != 0) {
//                 i--;
//                 continue;
//             }
//             int zero = i--;
//             // [2, 0, 0]
//             // nums[i] + i = n - 1 should return true;
//             while (i >= 0 && nums[i] + i <= zero && nums[i] + i < n - 1) {
//                 i--;
//             }
//             if (i == -1) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }
// slow dp
// but can see dp[j] update true when leftmost i reached
// class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         boolean[] dp = new boolean[n];
//         dp[0] = true;
//         for (int i = 0; i < n; i++) {
//             if (!dp[i]) {
//                 continue;
//             }
//             for (int j = i + 1; (j < n) && (j <= i + nums[i]); j++) {
//                 dp[j] = true;
//             }
//             if (dp[n - 1]) {
//                 break;
//             }
//         }
//         return dp[n - 1];
//     }
// }
