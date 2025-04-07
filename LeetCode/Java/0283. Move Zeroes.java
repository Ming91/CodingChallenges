class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return;
    }
}
// swap if found non zero. less array op in [0000001],but slower in leetcode

//move non-zero to front, add zero at last
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int i = 0, j = 0;
//         while (j < nums.length) {
//             while (j < nums.length && nums[j] == 0) {
//                 j++;
//             }
//             if (j < nums.length) {
//                 nums[i++] = nums[j++];
//             }
//         }
//         while (i < nums.length) {
//             nums[i++] = 0;
//         }
//         return;
//     }
// }
