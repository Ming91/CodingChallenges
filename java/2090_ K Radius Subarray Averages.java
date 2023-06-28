class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int len = nums.length;
        int[] ans = new int[len];
        int amount = k * 2 + 1;
        Arrays.fill(ans, -1);
        if (len < amount) {
            return ans;
        }
        long currentSum = 0;
        for (int i = 0; i < amount; i++) {
            currentSum += nums[i];
        }
        ans[amount - 1 - k] = (int) (currentSum / amount);
        for (int i = amount; i < len; i++) {
            currentSum += nums[i];
            currentSum -= nums[i - amount];
            //System.out.println(currentSum);
            ans[i - k] = (int) (currentSum / amount);
            
        }
        return ans;
    }
}
