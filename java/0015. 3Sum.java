// Top Interview 150 Two Pointers Q5
class Solution {
        void twoSum(int[] numbers, int i, List<List<Integer>> ans) {
        int n = numbers.length;
        int target = -numbers[i];
        int l = i + 1, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int sum = numbers[l] + numbers[r];
            if (sum < target) {
                if (numbers[mid] + numbers[r] >= target) {
                    l++;
                } else {
                    l = mid + 1;
                }
            } else if (sum > target) {
                if (numbers[l] + numbers[mid] <= target) {
                    r--;
                } else {
                    r = mid - 1;
                }
            } else {
                ans.add(List.of(numbers[i], numbers[l++], numbers[r--]));
                while (l < r && numbers[l - 1] == numbers[l]) {
                    l++;
                }
            }
        }
        return ;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, ans);
            }
        }
        return ans;
    }
}
// use 167. Two Sum II
