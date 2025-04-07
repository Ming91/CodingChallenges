// Daily Question 10/03/2023
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < 101; i++) {
            ans += (count[i] - 1) * count[i] / 2;
        }
        return ans;
    }
}
