// Weekly Contest 368 Q2
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        prev[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            prev[i] = Math.min(prev[i - 1], nums[i - 1]);
        }
        int succ = nums[n - 1];
        int ans = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            succ = Math.min(succ, nums[i + 1]);
            if (succ < nums[i] && prev[i] < nums[i]) {
                ans = Math.min(ans, prev[i] + nums[i] + succ);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
// [Ming]
//  Trade space for time. Preprocess prefix and suffix min then compare. 

// [TODO]
//  Find relation with '456. 132 Pattern' and '2874. Maximum Value of an Ordered Triplet II'

// [Ming] Failed monotonic stack solution. [2, 3, 2, 1] wont work. 
// class Solution {
//     public int minimumSum(int[] nums) {
//         int n = nums.length;
//         int[] stack = new int[n];
//         int inf = 300_000_001;
//         int p = 0;
//         int ans = inf;
//         for (int i = 1; i < n; i++) {
//             while (p > 0 && nums[stack[p]] > nums[i]) {
//                 ans = Math.min(ans, nums[stack[0]] + nums[stack[p--]] + nums[i]);
//             }
//             while (p >= 0 && nums[stack[p]] > nums[i]) {
//                 p--;
//             }
//             stack[++p] = i;
//         }
//         return ans == inf ? -1 : ans;
//     }
// }
