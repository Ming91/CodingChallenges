// Top Interview 150 Kadane's Algorithm Q2
class Solution {
    int kadane(int[] nums) {
        int currMax = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currMax = Math.max(currMax, 0) + num;
            maxSum = Math.max(maxSum, currMax);
        }
        return maxSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int maxAns = kadane(nums);
        if (maxAns < 0) {
            return maxAns;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = -nums[i];
        }
        return Math.max(maxAns, sum + kadane(nums));
    }
}
// [Beat 99%]
//  Invert the nums to -nums while computing the sum,
//  Kadane(-nums) = -minArraySum

// [Editorial] Use sum - minArraySum and maxArraySum to get answer. 
//  A little bit tricky, but O(1) space and beautiful.
// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int minRes = 0;
//         int maxRes = 0;
//         int minAns = Integer.MAX_VALUE;
//         int maxAns = Integer.MIN_VALUE;
//         int sum = 0;
//         for (int num : nums) {
//             maxRes = Math.max(maxRes, 0) + num;
//             maxAns = Math.max(maxAns, maxRes);

//             minRes = Math.min(minRes, 0) + num;
//             minAns = Math.min(minAns, minRes);

//             sum += num;
//         }
//         // all negative
//         if (sum == minAns) {
//             return maxAns;
//         }
//         return Math.max(maxAns, sum - minAns);
//     }
// }

// [Editorial]
//  Use a loop to calculate an array rightMax 
//  to store the max array sum that start from n - 1 and end before i.
//  use leftSum[i] + rightMax[i] to get circular sum. 
// class Solution {
//     public int maxSubarraySumCircular(int[] nums) {
//         int res = 0;
//         int ans = Integer.MIN_VALUE;
//         int n = nums.length;
//         int[] rightMax = new int[n];
//         for (int i = n - 1; i > 0; i--) {
//             res += nums[i];
//             rightMax[i - 1] = Math.max(rightMax[i], res);
//         }
//         res = 0;
//         int sum = 0;
//         int crossAns = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             res = Math.max(res, 0) + nums[i];
//             ans = Math.max(ans, res);
//             sum += nums[i];
//             crossAns = Math.max(crossAns, sum + rightMax[i]);
//         }
//         return Math.max(ans, crossAns);
//     }
// }

// [Ming] Tried, but failed, and many times. 
