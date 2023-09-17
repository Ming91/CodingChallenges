// Top Interview 150 Array / String Q2
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return i;
    }
}
// another way, need to understand better

// better way
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int n = nums.length;
//         int k = n;
//         int i = 0, j = 0;
//         // for-loop version
//         for ( ; j < n; j++){
//             if (nums[j] != val) {
//                 nums[i++] = nums[j];
//             }
//         }
//         // while version
//         // while (j < n) {
//         //     while (j < n && nums[j] == val) {
//         //         j++;
//         //     }
//         //     if (j < n) {
//         //         nums[i++] = nums[j++];
//         //     }
//         // }
//         return i;
//     }
// }

// stupid first try
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int n = nums.length;
//         int k = n;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == val) {
//                 k--;
//                 nums[i] = -1;
//             }
//         }
//         int i = 0, j = 0;
//         while (j < n) {
//             while (j < n && nums[j] < 0) {
//                 j++;
//             }
//             if (j < n) {
//                 nums[i++] = nums[j++];
//             }
//         }
//         return k;
//     }
// }
