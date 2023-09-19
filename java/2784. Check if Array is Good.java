// Biweekly Contest 109
class Solution {
    public boolean isGood(int[] nums) {
        int max = 0;
        int[] check = new int[nums.length];
        for (int num : nums) {
            if (num >= nums.length) {
                return false;
            }
            check[num]++;
            max = Math.max(max, num);
        }
        if (max != nums.length - 1) {
            return false;
        }
        for (int i = 1; i < max; i++) {
            if (check[i] != 1) {
                return false;
            }
        }
        if (check[max] != 2) {
            return false;
        }
        return true;
    }
}
