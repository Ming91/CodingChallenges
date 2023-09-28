// Daily Question 09/28/2023
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int r = n - 1;
        int l = 0;
        int temp = 0;
        while (l < r) {
            if ((nums[l] & 1) == 1) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r--] = temp;
            } else {
                l++;
            }
        }
        return nums;
    }
}
