// Top Interview 150 Array / String Q4
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 1, i = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j - 1] != nums[j]) {
                nums[i++] = nums[j];
                count = 1;
                continue;
            }
            if (count == 1) {
                nums[i++] = nums[j];
                count++;
            }
        }
        return i;
    }
}
