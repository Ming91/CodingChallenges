// Weekly Contest 362 Q1
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, (a, b) -> (a.get(0) - b.get(0)));
        int ans = 0;
        int l = 0, r = 0;
        for (List<Integer> num : nums) {
            if (num.get(0) > r) {
                ans += num.get(1) - num.get(0) + 1;
                r = num.get(1);
                l = num.get(0);
                continue;
            }
            if (num.get(1) > r ) {
                ans += num.get(1) - r;
                r = num.get(1);
            }
        }
        return ans;
    }
}
