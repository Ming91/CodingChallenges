// Daily Challenge 08/15/2023
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] right = new int[k];
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i += k) {
            int j = Math.min(n - i, k);
            int max = nums[i];
            if (i >= k) {
                // update answer for previous window
                for (int x = 1; x < j; x++) {
                    ans[i + x - k] = Math.max(max, right[x]);
                    max = Math.max(max, nums[x + i]);
                }
            }
            
            if (i > n - k) {
                // if last window if smaller than k, we need compute last window ans
                ans[n - k] = Math.max(max, right[j]);
                return ans;
            }
            max = nums[i + j - 1];
            for (int x = j - 1; x >= 0; x--) {
                max = Math.max(max, nums[x + i]);
                right[x] = max;
            }
            ans[i] = max;
        }
        return ans;
    }
}
// improve the idea below to O(k) space
// idea: direct generate corresponding ans when update left,
// 1. we can update the ans for the previous interval when enter the next one
//      [0, k - 1] [k, 2k - 1]... when we reach k, ans[0] can be updated with right[0]
//      and ans[1~k-1] = max(left, right[1~k-1])
// 2. when i>=n - k, it means last interval, 
//      we don't need to calc right, just update the ans for last window


// better idea, window max
// we calculate the left max and right max for intervals with k
// such as: [0, k-1], [k, 2k-1]...
// for each invterval, we get the left max and right max for each point.
// just consider the max in each interval

// now for each window start i, the end is i + k - 1,
// rightmax[i] is the max for [i, right range of interval for i]
// leftmax[i + k - 1] is the max for [left range of ..., i + k - 1]
// so max for [i, i + k - 1] is max(rightmax[i], leftmax[i + k - 1])
// O(n) w/ O(n) can be O(k) space

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int[] left = new int[n], right = new int[n];
//         for (int i = 0; i < n; i += k) {
//             int j = Math.min(n, i + k);
//             int max = nums[i];
//             for (int x = i; x < j; x++) {
//                 max = Math.max(max, nums[x]);
//                 left[x] = max;
//             }
//             max = nums[j - 1];
//             right[j - 1] = max;
//             for (int x = j - 1; x >= i; x--) {
//                 max = Math.max(max, nums[x]);
//                 right[x] = max;
//             }
//         }
//         int[] ans = new int[n - k + 1];
//         for (int i = 0; i < n - k + 1; i++) {
//             ans[i] = Math.max(right[i], left[i + k - 1]);
//         }
//         return ans;
//     }
// }

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int[] ans = new int[n - k + 1];
//         int[] dq = new int[n];
//         int l = 0;
//         int r = 0;
//         for (int i = 0; i < k; i++) {
//             while (l != r && dq[r - 1] < nums[i]) {
//                 r--;
//             }
//             dq[r++] = nums[i];
//         }
//         ans[0] = dq[l];
//         for (int i = k; i < n; i++) {
//             if (dq[l] == nums[i - k]) {
//                 l++;
//             }
//             while (l != r && dq[r - 1] < nums[i]) {
//                 r--;
//             }
//             dq[r++] = nums[i];
//             ans[i - k + 1] = dq[l];
//         }
//         return ans;
//     }
// }

// O(n) since each point at most in and out once.
// deque array impl space O(n)

// deque built-in impl, space O(k)
// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int[] ans = new int[n - k + 1];
//         Deque<Integer> dq = new LinkedList<>();
//         for (int i = 0; i < k; i++) {
//             while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
//                 dq.pollLast();
//             }
//             dq.addLast(nums[i]);
//         }
//         ans[0] = dq.peek();
//         for (int i = k; i < n; i++) {
//             if (dq.peek() == nums[i - k]) {
//                 dq.poll();
//             }
//             while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
//                 dq.pollLast();
//             }
//             dq.addLast(nums[i]);
//             ans[i - k + 1] = dq.peek();
//         }
//         return ans;
//     }
// }
