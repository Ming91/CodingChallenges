// Weekly Contest 363 Q2
class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if ((i == 0 || nums.get(i - 1) < i) && (i == n || nums.get(i) > i)) {
                // System.out.println(i);
                ans++;
            }
        }
        // System.out.println("------");
        return ans;
    }
}
