// LeetCode 75 Sliding Window Q1
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = l + k;
        long sum = 0;
        long max;
        for (int i = l; i < r; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = r; i < n; i++) {
            int diff = nums[i] - nums[i - k];
            sum += diff;
            max = Math.max(max, sum);
        }
        return (double)max / k;
    }
}
