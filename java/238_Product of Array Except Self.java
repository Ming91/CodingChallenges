class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            pre *= nums[i - 1];
            ans[i] = pre;
        }
        for (int i = n - 2; i >= 0; i--) {
            suff *= nums[i + 1];
            ans[i] *= suff;
        }
        return ans;
    }
}
