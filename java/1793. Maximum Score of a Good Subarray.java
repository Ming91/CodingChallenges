// Daily Question 10/22/2023
class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int l = k - 1;
        int r = k + 1;
        int ans = nums[k];
        int min = nums[k];
        int res = 0;
        while (l >= 0 || r < n) {
            if (l == -1 || ((r < n) && (nums[r] > nums[l]))) {
                min = Math.min(min, nums[r]);
                r++;
            } else {
                min = Math.min(min, nums[l]);
                l--;
            }
            // [Beat 99%] ignore no impact indices, just add-on
            while (r < n && nums[r] >= min) {
                r++;
            }
            while (l >= 0 && nums[l] >= min) {
                l--;
            }
            
            res = min * (r - l - 1);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
// [Editorial] 
//  Greedy, add larger one in left and right. 
//  Prove, if [l] < [r] and add [r], but [l] is in optimal:
//  then we can add [r] to simply improve the answer, done！

// [Editorial] Monotonic stack method,
//  left[i] and right[i] as the left and right next index j that nums[j] < nums[i]. 
//  for internals include k, ans = Max((right[i] - left[i] - 1) * nums[i])

// class Solution {
//     public int maximumScore(int[] nums, int k) {
//         int n = nums.length;
//         int[] left = new int[n];
//         int[] right = new int[n];
//         int[] stack = new int[n];
//         int p = 0;
//         Arrays.fill(right, n);
//         for (int i = 0; i < n; i++) {
//             while (p > 0 && nums[stack[p - 1]] > nums[i]) {
//                 p--;
//                 right[stack[p]] = i;
//             }
//             stack[p++] = i;
//         }
//         p = 0;
//         Arrays.fill(left, -1);
//         for (int i = n - 1; i >= 0; i--) {
//             while (p > 0 && nums[stack[p - 1]] > nums[i]) {
//                 p--;
//                 left[stack[p]] = i;
//             }
//             stack[p++] = i;
//         }
//         // System.out.println(Arrays.toString(left));
//         // System.out.println(Arrays.toString(right));
//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             if (left[i] < k && right[i] > k) {
//                 ans = Math.max(ans, (right[i] - left[i] - 1) * nums[i]);
//             }
//         }
//         return ans;
//     }
// }
