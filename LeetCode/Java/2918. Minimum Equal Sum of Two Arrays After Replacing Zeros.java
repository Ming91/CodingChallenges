// Weekly Contest 369 Q2
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int count1 = 0, count2 = 0;
        long sum1 = 0, sum2 = 0;
        for (int num : nums1) {
            if (num == 0) {
                count1++;
                sum1++;
            } else {
                sum1 += num;
            }
        }
        for (int num : nums2) {
            if (num == 0) {
                count2++;
                sum2++;
            } else {
                sum2 += num;
            }
        }
        if (sum1 > sum2 && count2 == 0) {
            return -1;
        }
        if (sum2 > sum1 && count1 == 0) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}
// [Lee]

// [Ming]
// class Solution {
//     long calc(long sum1, long sum2, int count1, int count2) {
//         if (sum1 == sum2) {
//             return sum1;
//         }
//         if (sum1 < sum2) {
//             return calc(sum2, sum1, count2, count1);
//         }
//         if (count2 == 0) {
//             return -1;
//         }
//         return sum1;
//     }
//     public long minSum(int[] nums1, int[] nums2) {
//         int count1 = 0, count2 = 0;
//         long sum1 = 0, sum2 = 0;
//         for (int num : nums1) {
//             sum1 += num;
//             count1 += num == 0 ? 1 : 0;
//         }
//         for (int num : nums2) {
//             sum2 += num;
//             count2 += num == 0 ? 1 : 0;
//         }
//         return calc(sum1 + count1, sum2 + count2, count1, count2);
//     }
// }
