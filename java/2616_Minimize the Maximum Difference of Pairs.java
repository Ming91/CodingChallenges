// Daily Challenge 08/08/2023
class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        if (p == 0 || n == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int l = 0;
        int r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = (l + r) >> 1;
            int ans = 0;
            for (int i = 0; i < n - 1 && ans < p; i++) {
                if (nums[i + 1] - nums[i] <= mid) {
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
// 二分加贪心
//  如果[i-1, i]和[i, i+1]都满足, 那么取前者, 因为前者给后面留的"机会更多"
//  这也是贪心可行的原因
// 自己的想法是想到排序之后求差, 不清楚如何继续了, 想了贪心又想了dp
// 二分搜索的确是需要培养的思维方式
