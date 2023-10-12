// Top Interview 150 Kadane's Algorithm Q1
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        int res = 0;
        for (int num : nums) {
            res = Math.max(0, res) + num;
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
// [Ming] This is actually the Kadane's Algo, res is maxEndHere, ans is maxSoFar.
