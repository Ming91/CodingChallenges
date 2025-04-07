// Biweekly Contest 112 Q3
class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.size();
        int l = 0, r = 0;
        for (; r < k; r++) {
            int curr = nums.get(r);
            res += curr;
            count.put(curr, count.getOrDefault(curr, 0) + 1);
        }
        if (count.size() >= m) {
            ans = res;
        }
        r = k;
        while (r < n) {
            int left = nums.get(l++);
            int right = nums.get(r++);
            res += right - left;
            if (count.get(left) == 1) {
                count.remove(left);
            } else {
                count.put(left, count.get(left) - 1);
            }
            count.put(right, count.getOrDefault(right, 0) + 1);
            if (count.size() >= m && res > ans) {
                ans = res;
            }
        }
        return ans;
    }
}
