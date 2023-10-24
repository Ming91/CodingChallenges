// Daily Question 10/24/2023
// class Solution {
//     public int constrainedSubsetSum(int[] nums, int k) {
//         Deque<Integer> queue = new ArrayDeque<>();
//         int n = nums.length;
//         int[] dp = new int[n];
//         int max = nums[0];
//         for (int i = 0; i < n; i++) {
//             if (!queue.isEmpty() && i - queue.peekFirst() > k) {
//                 queue.pollFirst();
//             }
//             dp[i] = (queue.isEmpty() ? 0 : dp[queue.peekFirst()]) + nums[i];
//             while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]) {
//                 queue.pollLast();
//             }
//             if (dp[i] > 0) {
//                 queue.addLast(i);
//             }
//             max = Math.max(max, dp[i]);
//         }
//         return max;
//     }
// }
// [Editorial] 
//  Decreasing monotonic stack. 

// [Beat 99%]
//  Max is the best result of `last step`,
//  For the first k, it just the add nums[i] when its positive, 
//  since we can always reach the idxMax. 
//  For later index, we need to update max while checking if we can reach it,
//  so when (i + k == idxMax), we need to update idxMax with a closesr result. 
//  The complexity looks like k + (n - k) * k + n, while k = (n + 1)/2 will hit the max. 
//  {Worst case discuss}
// // This is not bad enough!
// //  and the worst case will be like [0, ..., 0, 100], 
// //  which makes us need to use the loop to update every k indices. 
// //  (the loop update from i to idxMax - 1)
//  Consider [-100, -99, ..., -1]
//  This will always using the loop for every indices. 
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {

        int idxMax = nums.length - 1;
        int max = nums[idxMax];
        int i = nums.length - 2;

        for (; i >= nums.length - k; i--) {

            if (max > 0) nums[i] += max;

            if (nums[i] > max) {
                max = nums[i];
                idxMax = i;
            }
        }

        for (; i >= 0; i--) {
            
            if (max > 0) nums[i] += max;

            if (nums[i] > max) {
                max = nums[i];
                idxMax = i;
            }

            if (i + k == idxMax) {
                max = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        idxMax = j;
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;

        for (int sum : nums) {
            if (sum > res) res = sum;
        }

        return res;
    }
}
// [A more obscure stack] 
//  Use value rather than index, and use in space method. 
//  Since pollLast() while A[i] > q.peekLast(),
//  If q.peek() == A[i-k], means there is no better result in [i-k~i],
//  or the better result well take the first place. 
// class Solution {
    
//     public int constrainedSubsetSum(int[] A, int k) {
//         int res = A[0];
//         Deque<Integer> q = new ArrayDeque<>();
//         for (int i = 0; i < A.length; ++i) {
//             //递减栈，peek是最左边的数所以是取最大值，这个DP限定A[i]必选，也是这一行保证每隔k选一个
//             A[i] += !q.isEmpty() ? q.peek() : 0; 
//             res = Math.max(res, A[i]);
//             while (!q.isEmpty() && A[i] > q.peekLast())
//                 q.pollLast();
//             //这里的A[i]代表的已经是DP了
//             if (A[i] > 0)
//                 q.offer(A[i]);
//             //因为用的deque，所以peek是最左边
//             if (i >= k && !q.isEmpty() && q.peek() == A[i - k])
//                 q.poll();
//         }
//         return res;
//     }
// }
