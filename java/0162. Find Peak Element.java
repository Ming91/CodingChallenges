// Top Interview 150 Binary Search Q3
// LeetCode 75 Binary Search Q3
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
// better structure practice
// see it as a increasing function, find the turnaround point 

// naive binary search
// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n = nums.length;
//         if (n == 1 || nums[0] > nums[1]) {
//             return 0;
//         }
//         if (nums[n - 1] > nums[n - 2]) {
//             return n - 1;
//         }
//         int l = 1;
//         int r = n - 2;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
//                 return mid;
//             }
//             if (nums[mid] < nums[mid - 1]) {
//                 r = mid;
//             } else {
//                 l = mid + 1;
//             }
//         }
//         return l;
//     }
// }
