// Top Interview 150 Q13
// 08/28/2023 Impl
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int prev = 1;
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            prev *= nums[i - 1];
            ans[i] = prev;
        }
        prev = 1;
        for (int i = n - 2; i >= 0; i--) {
            prev *= nums[i + 1];
            ans[i] *= prev;
        }
        return ans;
    }
}


// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int pre = 1;
//         int suff = 1;
//         int[] ans = new int[n];
//         ans[0] = 1;
//         for (int i = 1; i < n; i++) {
//             pre *= nums[i - 1];
//             ans[i] = pre;
//         }
//         for (int i = n - 2; i >= 0; i--) {
//             suff *= nums[i + 1];
//             ans[i] *= suff;
//         }
//         return ans;
//     }
// }
