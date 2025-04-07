// Daily Question 09/20/2023
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        if (sum < x) {
            return -1;
        }
        if (sum == x) {
            return n;
        }
        int l = 0;
        int ans = n + 1;
        for (int r = 0; r < nums.length; r++) {
            sum -= nums[r];
            // if don't check total sum == x (ans = n case) in advance, 
            // should be l <= r
            while (sum < x && l < r) {
                sum += nums[l++];
            }
            if (sum == x) {
                ans = Math.min(ans, l + n - r - 1);
            }
        }
        return ans > n ? -1 : ans;
    }
}
// [Editorial] Two pointers, at most O(n * 2)

// [Ming] HashMap Impl, O(n * 2)
// class Solution {
//     public int minOperations(int[] nums, int x) {
//         int n = nums.length;
//         int sum = 0;
//         int idx = 0;
//         Map<Integer, Integer> dict = new HashMap<>();
//         dict.put(0, 0);
//         while (idx < n && sum < x) {
//             sum += nums[idx++];
//             dict.put(sum, idx);
//         }
//         if (idx == n && sum < x) {
//             return -1;
//         }
//         idx = n - 1;
//         sum = 0;
//         int ans = dict.getOrDefault(x, n + 1);
//         while (idx >= 0 && sum < x) {
//             sum += nums[idx--];
//             int res = dict.getOrDefault(x - sum, n + 1) + n - idx - 1;
//             ans = Math.min(ans, res);
//         }
//         return ans > n ? -1 : ans;
//     }
// }
