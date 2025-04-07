// LeetCode 75 Bit Manipulation Q2
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        // int ans = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     ans = ans ^ nums[i];
        // }
        return ans;
    }
}
// math problem, xor make it O(n) with O(1)
