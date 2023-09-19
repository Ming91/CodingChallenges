// Weekly Contest 358 Q3
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> s = new TreeSet<>();
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for (int i = x; i < n; i++) {
            s.add(nums.get(i - x));
            Integer floor = s.floor(nums.get(i));
            Integer ceil = s.ceiling(nums.get(i));
            if (floor != null) {
                min = Math.min(min, nums.get(i) - floor);
            }
            if (ceil != null) {
                min = Math.min(min, ceil - nums.get(i));
            }
        }
        return min;
    }
}
// learn how to use TreeSet with floor() and ceiling()
