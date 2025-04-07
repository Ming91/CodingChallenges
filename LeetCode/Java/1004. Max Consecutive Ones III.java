// LeetCode 75 Sliding Window Q3
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) {
            return n;
        }
        int l = 0;
        for (int r = 0; r < n; r++) {
            // 减少库存
            k -= nums[r] ^ 1;
            if (k < 0) {
                // 欠费了
                k += nums[l] ^ 1;
                // window 无法上涨,要跟着向右滑动
                l++;
            }
        }
        return n - l;
    }
}
// beat 99% idea:
//      //  想象一下构造上升subseq, 构造的结果不一定是满足条件的,但是长度是满足的
//      更贴近的:340_Longest Substring with At Most K Distinct Characters
//      "不用左边缩到valid sub为止,只用缩到ans长度,
//      不valid也无所谓,如果left到right大于ans且valid,更新ans"

//      长度只上升不下降,因此不需要缩左边到valid
//      只需要记录"欠了几个" 即可


// 想法: 滑动, 是1直接加, 是0看看够不够,够也直接加
// 不够就从左边减少
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int n = nums.length;
//         if (k >= n) {
//             return n;
//         }
//         int count = 0;
//         int used = 0;
//         int l = 0;
//         int r = l;
//         int max = 0;
//         while (r < n) {
//             int curr = nums[r];
//             if (curr == 0 && used == k) {
//                 while (nums[l] == 1 && l < r) {
//                     // count--;
//                     l++;
//                 }
//                 l++;
//                 used--;
//             }
//             // count += curr;
//             used += 1 - curr;
//             r++;
//             max = Math.max(max, r - l);
//         }
//         return max;
//     }
// }
