// Top Interview 150 Binary Search Q4
// Daily Challenge 08/07/2023

// Top Interview 10/13/2023 Impl
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // [l ~ mid] ordered
            if (nums[l] <= nums[mid]) {

                // check target in [mid ~ r], a little complicated
                // if (nums[mid] < target || (nums[l] > target && target <= nums[r])) {
                //     l = mid + 1;
                // } else {
                //     r = mid;
                // }

                // check target in [l ~ mid], looks easier
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
                continue;
            }
            // [mid ~ r] ordered
            // check target in [mid ~ r]
            if (nums[mid] < target && target <= nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }
}

// Daily Challenge 08/07/2023
// class Solution {
//     public int search(int[] nums, int target) {
//         int n = nums.length;
//         int l = 0;
//         int r = n - 1;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             if (nums[mid] == target) {
//                 return mid;
//             }
//             // l~mid sorted
//             if (nums[mid] >= nums[l]) {
//                 if (nums[mid] > target && target >= nums[l]) {
//                     r = mid - 1;
//                 } else {
//                     l = mid + 1;
//                 }
//             } else {
//             // mid~r sorted

//                 if (nums[mid] < target && target <= nums[r]) {
//                     l = mid + 1;
//                 } else {
//                     r = mid - 1;
//                 }
//             }

            
            
//         }
//         return nums[l] == target ? l : -1;
//     }
// }
// nb的一次二分搜索, 只要有序, 就可以搜!
// 长脑子的一集

// ugly two binary search
// 第二次的坐标转换没搞好, 第一次的条件也没搞好
// class Solution {
//     int bsPivot(int[] nums) {
//         int n = nums.length;
//         int l = 0;
//         int r = n - 1;
//         while (l < r) {
//             int mid = (l + r + 1) >> 1;
//             if (nums[mid] > nums[l]) {
//                 l = mid;
//             } else {
//                 r = mid - 1;
//             }
//        //    下面的返回l, 另一种条件
//        //     int mid = (l + r) >> 1;
//        //     if (nums[l] > nums[n - 1]) {
//        //         l = mid + 1;
//        //     } else {
//        //         r = mid - 1
//        //     }
//         }
//         return l + 1;
//     }
//     int bs(int base, int[] nums, int target) {
//         int n = nums.length;
//         // int l = base % n;
//         // int r = (base - 1 + n) % n;
//         // int mid;
//         // while (nums[l] < nums[r]) {
//         //     if (l < r) {
//         //         mid = (l + r) >> 1;
//         //     } else {
//         //         mid = (l + r + n) >> 1;
//         //         mid = mid % n;
//         //     }
//         //     if (nums[mid] < target) {
//         //         l = (mid + 1) % n;
//         //     } else {
//         //         r = mid % n;
//         //     }
//         // }
//         int l = 0;
//         int r = n - 1;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             if (nums[(mid + base) % n] < target) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         l = (l + base) % n;
//         return nums[l] == target ? l : -1;
//     }
//     public int search(int[] nums, int target) {
//         int n = nums.length;
//         if (n == 1) {
//             return nums[0] == target ? 0 : -1;
//         }
//         if (nums[0] > nums[n - 1]) {
//             if (target < nums[0] && target > nums[n - 1]) {
//                 return -1;
//             }
//             int pivot = bsPivot(nums);
//             System.out.println(pivot);
//             return bs(pivot, nums, target);
//         } else {
//             if (target < nums[0] || target > nums[n - 1]) {
//                 return -1;
//             }
//             return bs(0, nums, target);
//         }

//     }
// }
