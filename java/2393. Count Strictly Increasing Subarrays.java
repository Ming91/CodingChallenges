// Weekly Premium Sep 2023 W5
class Solution {
    public long countSubarrays(int[] nums) {
        int n = nums.length;
        long ans = n;
        long len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                ans += len * (len - 1) / 2;
                len = 1;
            }
        }
        ans += len * (len - 1) / 2;
        return ans;
    }
}
