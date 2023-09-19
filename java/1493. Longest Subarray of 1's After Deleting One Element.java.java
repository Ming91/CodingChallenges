// LeetCode 75 Sliding Window Q4
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int k = 1;
        for (int i = 0; i < n; i++) {
            k -= nums[i] ^ 1;
            if (k < 0) {
                k += nums[l] ^ 1;
                l++;
            }
        }
        // k = k < 0 ? 0 : k;
        return n - l - 1; 
    }
}
// use method from 1004

// Before 07/31/2023
// class Solution {
//     public int longestSubarray(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         int left = 0;
//         int numZero = 0;
//         int lastZero = -1;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == 0) {
//                 numZero++;
//                 if (numZero == 1) {
//                     lastZero = i;
//                 }
//                 if (numZero > 1) {
//                     left = lastZero + 1;
//                     numZero--;
//                     lastZero = i;
//                 }
//             }
//             // tricky compare, if all 1, len - 1, if 1 zero, still len - 1
            
//             if (i - left> ans) {
//                 ans = i - left;
//             }
//             // if use code below, still need delete 1 more for all 1;
//             // if (i - left - numZero + 1 > ans) {
//             //     ans = i - left - numZero + 1;
//             // }
//             // add 1 more compare for all 1 situation
//             // ans = ans == n ? n - 1 : ans;
//         }
//         return ans;
//     }
// }

// intuition slidiing window
// class Solution {
//     public int longestSubarray(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         int left = 0;
//         int right = left;
//         int lastZero = -1;
//         int numZero = 0;
//         while (right < n) {
//             // nums[] == 1
//             if (nums[right] == 1) {
//                 right++;
//                 continue;
//             }

//             // nums[] == 0 && numZero == 0
//             // eg:1 1 (0) 1
//             // record the zero pos, add #zero, go nxt
//             if (numZero == 0) {
//                 lastZero = right;
//                 numZero +=1;
//                 right++;
//                 continue;
//             }
//             // nums[] == 0 && numZero == 1
//             // 1 1 0 1 (0)

//             // if longer than ans, ans = length
//             if (right - left - numZero > ans) {
//                 ans = right - left - numZero;
//             }
//             // shrink left to the nxt of last zero
//             // record current 0 as last zero, then go nxt;
//             left = lastZero + 1;
//             lastZero = right;
//             right++;
//         }
//         // if to the end
//         if (right - left - numZero > ans) {
//             ans = right - left - numZero;
//         }
//         if (ans == n) {
//             return n - 1;
//         }
//         return ans;
//     }
// }
// intuition idea O(n) with O(n)
// class Solution {
//     public int longestSubarray(int[] nums) {
//         int numZero = 0;
//         int ans = 0;
//         int i = 0;
//         int n = nums.length;
//         int[] subIdx = new int[n];
//         int[] subLen = new int[n];
//         int k = 0;
//         while (i < n) {
//             while (i < n && nums[i] == 0) {
//                 i++;
//             }
//             int idx = i;
//             subIdx[k] = idx;
//             while (i < n && nums[i] == 1) {
//                 i++;
//             }
//             subLen[k] = i - idx;
//             k++;
//         }
//         if (subIdx[0] == n) {
//             return 0;
//         }
//         if (subLen[0] == n) {
//             return n - 1;
//         }
//         for (int j = 0; j < k; j++) {
//             int len = subLen[j];
//             if (j <= k - 2 && subIdx[j] + subLen[j] + 1 == subIdx[j + 1]) {
//                 len += subLen[j + 1];
//             }
//             if (ans < len) {
//                 ans = len;
//             }
//         }
//         return ans;
//     }
// }