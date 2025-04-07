// Top Interview 150 Binary Search Q6
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[n - 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
// [Beat 99%]
//  Much better structure. 

// class Solution {
//     public int findMin(int[] nums) {
//         int n = nums.length;
//         // if n == 1 or 2, equal is needed to check. 
//         if (nums[n - 1] >= nums[0]) {
//             return nums[0];
//         }
//         int l = 0;
//         int r = n - 1;
//         while (l < r) {
//             int mid = (l + r) / 2;
//             // [Editorial] 
//             // if mid == 0, and [mid]<[mid+1], 
//             //  means nums[0] <= nums[n-1], checked before. 
//             if (nums[mid] > nums[mid + 1]) {
//                 return nums[mid + 1];
//             }
//             // mid == 0 is all checked, so safe here. 
//             if (nums[mid] < nums[mid - 1]) {
//                 return nums[mid];
//             }
//             if (nums[mid] > nums[0]) {
//                 l = mid + 1;
//             } else {
//                 r = mid - 1;
//             }
//             // [Ming] Version 1.0
//             // if (nums[l] <= nums[mid] && nums[mid] > nums[r]) {
//             //     l = mid + 1;
//             // } else {
//             //     r = mid;
//             // }
//             // [Ming] Version 0.1
//             // if (nums[l] <= nums[mid]) {
//             //     if (nums[mid] < nums[r]) {
//             //         r = mid;
//             //     } else {
//             //         l = mid + 1;
//             //     }
//             //     continue;
//             // }
//             // r = mid;
//         }
//         // [Editorial]
//         return Integer.MAX_VALUE;
//         // [Ming] version
//         // return nums[l];
//     }
// }
