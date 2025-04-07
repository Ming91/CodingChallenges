// Daily Challenge 08/08/2023
class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        // change from equal check to smaller check, turns out faster
        if (p <= 0 || n <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        // 改进part1
        int[] diff = new int[n];
        int maxDiff = 0;
        for (int i = 0; i < n - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        int l = 0;
        int r = maxDiff;
        while (l < r) {
            int mid = (l + r) >> 1;
            int ans = 0;
            // 少比较更快
            // for (int i = 0; i < n - 1 && ans < p; i++) {
            for (int i = 0; i < n - 1; i++) {
                // 改进part2
                if (diff[i] <= mid) {
                    ans++;
                    i++;
                }
            }
            if (ans < p) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
// beat 99% idea:
// 需要反复比较差, 直接算好备用, 算的过程还可以求max, 缩小范围

// 二分加贪心
//  如果[i-1, i]和[i, i+1]都满足, 那么取前者, 因为前者给后面留的"机会更多"
//  这也是贪心可行的原因
// 自己的想法是想到排序之后求差, 不清楚如何继续了, 想了贪心又想了dp
// 二分搜索的确是需要培养的思维方式
