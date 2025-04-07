// Weekly Contest 359 Q4
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int[] count = new int[n + 1];
        int l = 0;
        int maxCount = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            int curr = nums.get(r);
            count[curr]++;
            maxCount = Math.max(maxCount, count[curr]);
            
            int removed = r - l + 1 - maxCount;
            if (removed > k) {
                count[nums.get(l)]--;
                l++;
            }
        }
        return maxCount;
    }
}
