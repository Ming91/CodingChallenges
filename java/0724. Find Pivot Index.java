// LeetCode 75 Prefix Sum Q2
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int ls = 0;
        int rs = sum;
        for (int i = 0; i < n; i++) {
            rs -= nums[i];
            if (ls == rs) {
                return i;
            }
            ls += nums[i];
        }
        return -1;
    }
}
// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int[] sum = new int[n];
//         sum[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             sum[i] += sum[i - 1] + nums[i];
//         }
//         int total = sum[n - 1];
//         for (int i = 0; i < n; i++) {
//             if ((sum[i] << 1) - total - nums[i] == 0) {
//                 return i;
//             }
//         }
//         // int l = 0;
//         // int r = n - 1;
//         // while (l < r) {
//         //     int mid = (l + r) >> 1;
//         //     int p = sum[mid] << 1 - total - nums[mid];
//         //     if (p < 0) {
//         //         l = mid + 1;
//         //     } else {
//         //         if (p == 0) {
//         //             return mid;
//         //         } else {
//         //             r = mid - 1;
//         //         }
//         //     }
//         // }
//         return -1;
//     }
// }
