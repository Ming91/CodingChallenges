// Top Interview 150 Binary Search Q5
// Daily Question 10/09/2023
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l == n || nums[l] != target) {
            return new int[] {-1, -1};
        }
        ans[0] = l;
        l = -1;
        r = n - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        ans[1] = r;
        return ans;
    }
}
// Two binary search, very typical problem to clear mind.
