// Weekly Contest 358 Q1
class Solution {
    public int maxSum(int[] nums) {
        int[] top1 = new int[10];
        int[] top2 = new int[10];
        for (int num : nums) {
            int k = num;
            int maxDigit = 0;
            while (k > 0) {
                maxDigit = Math.max(maxDigit, k % 10);
                k = k / 10;
            }
            if (top1[maxDigit] < num) {
                top2[maxDigit] = top1[maxDigit];
                top1[maxDigit] = num;
                continue;
            }
            if (top2[maxDigit] < num) {
                top2[maxDigit] = num;
            }
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (top2[i] != 0) {
                max = Math.max(max, top1[i] + top2[i]);
            }
        }
        return max > 0 ? max : -1;
    }
}
// 0~9 存最大的两个就行了

// 看错题的丑陋解法
// class Solution {
//     public int maxSum(int[] nums) {
//         int n = nums.length;
//         int[] s = new int[10_001];
//         int[] maxDigit = new int[10_001];
//         int maxNum = 0;
//         for (int num : nums) {
//             s[num]++;
//             maxNum = Math.max(maxNum, num);
//             int k = num;
//             while (k > 0) {
//                 maxDigit[num] = Math.max(maxDigit[num], k % 10);
//                 k = k / 10;
//             }
//         }
//         int max = 0;
//         for (int ii = n - 1; ii >= 0; ii--) {
//             for (int jj = ii - 1; jj >= 0; jj-- ) {
//                 int i = nums[ii];
//                 int j = nums[jj];
//                 if ((i != j && maxDigit[i] == maxDigit[j] && s[i] > 0 && s[j] > 0) || (i == j && s[i] > 1)) {
//                     max = Math.max(max, i + j);
//                 }
//             }
//         }
//         return max > 0 ? max : -1;
//     }
// }
