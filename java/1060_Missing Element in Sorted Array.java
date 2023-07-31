// Premium Challenge 07/2023 W5
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int start = nums[0];
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            int org = start + mid;
            if (nums[mid] - org < k) {
                l = mid;
            } else {
                r = mid - 1;
            }
            
        }
        return k + start + l;    
    }
}
//  优化: 二分
//  [2, 4, 7, 9, 10 ...]
//  idx的数num[idx] - num[0] - idx是目前少了几个数
//  不足k则向右, 反之向左
//  让最后找到的是正好不足的最后一个idx, 计算一下就能得到结果.

// 想法: 挨个遍历,如果"和下一个数的差" 不够 "所需的数",则这个数+所需的即可,
//      否则,将"所需的数" 减去 "和下一个数的差".
// class Solution {
//     public int missingElement(int[] nums, int k) {
//         int n = nums.length;
//         int r = k;
//         for (int i = 0; i < n - 1; i++) {
//             int diff = nums[i + 1] - nums[i];
//             if (diff == 1) {
//                 continue;
//             }
//             if (r <= diff - 1) {
//                 return nums[i] + r; 
//             } else {
//                 r -= diff - 1;
//             }
//         }
//         return nums[n - 1] + r;
//     }
// }
