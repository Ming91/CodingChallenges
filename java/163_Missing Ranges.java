class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            ans.add(Arrays.asList(lower, upper));
            return ans;
        }
        int previous = nums[0];
        if (lower < nums[0]) {
            ans.add(Arrays.asList(lower, nums[0] - 1));
        }
        
        for (int i : nums) {
            if (previous < i - 1) {
                ans.add(Arrays.asList(previous + 1, i - 1));
            }
            previous = i;
        }
        if (upper > nums[nums.length - 1]) {
            ans.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }
        return ans;
    }
}
