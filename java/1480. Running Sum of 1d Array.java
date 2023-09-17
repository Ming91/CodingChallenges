class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans;
        int len = nums.length;
        
        ans = new int[len];
        ans[0] = nums[0];
        for (int i = 1; i < len; i++) {
            ans[i] = nums[i] + ans[i - 1];
        }
        return ans;
    }
}
