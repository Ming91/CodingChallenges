class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> occuredNum = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!occuredNum.add(nums[i])) {
                return (i/3 + 1);
            }
        }
        return 0;
    }
}