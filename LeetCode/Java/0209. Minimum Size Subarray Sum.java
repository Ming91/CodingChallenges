// Top Interview 150 Sliding Window Q1
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0;
        int ans = n + 1;
        while (r < n) {
            while (r < n && sum < target) {
                sum += nums[r++];
            }
            while (sum >= target) {
                sum -= nums[l++];
            }
            ans = Math.min(ans, r - l + 1);
        }
        return ans == n + 1 ? 0 : ans;
    }
}
