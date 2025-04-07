// Weekly Contest 365 Q2
class Solution {
    public long maximumTripletValue(int[] nums) {
        long max, maxDiff, ans;
        max = 0;
        maxDiff = 0;
        ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, num * maxDiff);
            max = Math.max(max, num);
            maxDiff = Math.max(maxDiff, max - num);
        }
        return ans;
    }
}
// [Lee] one pass with O(1) space solution

// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int n = nums.length;
//         int[] prev = new int[n];
//         int[] succ = new int[n];
//         prev[0] = 0;
//         succ[n - 1] = 0;
//         for (int i = 1; i < n; i++) {
//             prev[i] = Math.max(prev[i - 1], nums[i - 1]);
//         }
//         for (int i = n - 2; i >= 0; i--) {
//             succ[i] = Math.max(succ[i + 1], nums[i + 1]);
//         }
//         long ans = 0;
//         for (int i = 1; i < n - 1; i++) {
//             ans = Math.max(ans, ((long)prev[i] - nums[i]) * succ[i]);
//         }
//         return ans;
//     }
// }
