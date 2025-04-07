// Top Interview 150 Array / String Q5
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int target = 0;
        for (int num : nums) {
            if (count == 0) {
                target = num;
            }
            count += (target == num ? 1 : -1);
        }
        return target;
    }
}
