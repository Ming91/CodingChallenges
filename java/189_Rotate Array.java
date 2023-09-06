// Top Interview 150 Array / String Q6
class Solution {
    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
}
// editorial 3 swap method, O(n) with O(1) space
// Original List                   : 1 2 3 4 5 6 7
// After reversing all numbers     : 7 6 5 4 3 2 1
// After reversing first k numbers : 5 6 7 4 3 2 1
// After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result


// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         k %= n;
//         for (int i = 0; i < k; i++) {
//             ans[i] = nums[n - k + i];
//         }
//         for (int i = k; i < n; i++) {
//             ans[i] = nums[i - k];
//         }
//         // This assign nums to a new addr
//         // But input nums which loc at old addr not modified
//         // nums = ans;
//         // System.out.println(Arrays.toString(nums));
//         for (int i = 0; i < n; i++) {
//             nums[i] = ans[i];
//         }
//     }
// }

// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         for (int i = 0; i < k; i++) {
//             int cache = nums[n - 1];
//             for (int j = n - 1; j > 0; j--) {
//                 nums[j] = nums[j - 1];
//             }
//             nums[0] = cache;
//         }
        
//     }
// }

// 1. n^2 sims
// 2. n extra array shift
// 3. kn with O(1) space cache
