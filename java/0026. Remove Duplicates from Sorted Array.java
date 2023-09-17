// Top Interview 150 Array / String Q3
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j - 1] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        // while (j < n) {
        //     int curr = nums[j];
        //     while (j < n && nums[j] == curr) {
        //         j++;
        //     }
        //     nums[i++] = curr;
        // }
        return i;
    }
}
