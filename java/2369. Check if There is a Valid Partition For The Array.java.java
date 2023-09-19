// Daily Challenge 08/13/2023
class Solution {
    public boolean validPartition(int[] nums) {
        
        int n = nums.length;
        if (n == 2) {
            return nums[0] == nums[1];
        }
        
        boolean prev3 = true;
        boolean prev2 = false;
        boolean prev1 = nums[1] == nums[0];
        boolean curr = false;
        for (int i = 2; i < n; i++) {
            curr = ((prev2 && nums[i] == nums[i - 1]) 
                    ||  (prev3 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2])  
                    ||  (prev3 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2));
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
// beat 99% idea:
// 用变量替代数组, 节约取余操作

// dp, 从i-2和i-3继承, i-2继承1种情况, i-3继承两种
// 注意下标, 0表示没有元素, 1表示有第一个元素,
// 所以初始值应该是0: true, 1: false, 2: nums[0] == nums[1]
// 因为最多到i-3, 因此可以用3维循环数组;
// class Solution {
//     public boolean validPartition(int[] nums) {
//         int n = nums.length;
//         if (n == 2) {
//             return nums[0] == nums[1];
//         }
//         boolean[] dp = new boolean[3];
//         dp[0] = true;
//         dp[1] = false;
//         dp[2] = nums[1] == nums[0];
//         for (int ii = 3; ii <= n; ii++) {
//             int im = ii % 3;
//             int i2 = (ii - 2) % 3;
//             int i = ii - 1;
//             if (nums[i] == nums[i - 1] && dp[i2]) {
//                 dp[im] = true;
//                 continue;
//             }
//             if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && dp[im]) {
//                 continue;
//             }
//             if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2 && dp[im]) {
//                 continue;
//             }
//             dp[im] = false;
//         }
//         return dp[n % 3];
//     }
// }
