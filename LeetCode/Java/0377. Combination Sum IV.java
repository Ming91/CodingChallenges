// Daily Question 09/09/2023
class Solution {
    Integer[] dp;
    int calcDP(int[] nums, int target) {
        if (target < 0) {
            return 0;
        }
        if (dp[target] != null) {
            return dp[target];
        }
        int sum = 0;
        for (int num : nums) {
            sum += calcDP(nums, target - num);
        }
        dp[target] = sum;
        return sum;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        dp[0] = 1;
        return calcDP(nums, target);
    }
}
