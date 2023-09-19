// Weekly Contest 355

class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        if (n < 2) {
            return nums[0];
        }
        ans = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans = nums[i] <= ans ? ans + nums[i] : nums[i];
        }
        return ans;
    }
}

// 从后往前, 前比后小就相加即可
