// Daily Question 09/29/2023
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean up = false;
        boolean down = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = true;
            }
            if (nums[i] < nums[i - 1]) {
                down = true;
            }
        }
        return !up || !down;
    }
}

// class Solution {
//     public boolean isMonotonic(int[] nums) {
//         int prev = 0;
//         for (int i = 1; i < nums.length; i++) {
//             int curr = Integer.compare(nums[i], nums[i - 1]);
//             if (curr == 0) {
//                 continue;
//             }
//             if (prev != 0 && prev != curr) {
//                 return false;
//             }
//             prev = curr;
//         }
//         return true;
//     }
// }

// class Solution {
//     public boolean isMonotonic(int[] nums) {
//         int p = 0;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 continue;
//             }
//             if (nums[i] > nums[i - 1]) {
//                 if (p < 0) {
//                     return false;
//                 }
//                 p = 1;
//                 continue;
//             }
//             if (p > 0) {
//                 return false;
//             }
//             p = -1;
//             continue;
//         }
//         return true;
//     }
// }
