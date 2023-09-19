// Daily Question 09/19/2023
class Solution {
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int temp = nums[0];
            nums[0] = nums[temp];
            nums[temp] = temp;
        }
        return nums[0];
    }
}
// Brilliant Question
// Treat array as linkedlist.
// The floyd's cycle detect is also great.
