// Weekly Contest 369 Q1
// class Solution {
//     public int findKOr(int[] nums, int k) {
//         int[] bit = new int[32];
//         for (int num : nums) {
//             for (int i = 0; i < 32; i++) {
//                 bit[i] += (num >> i) & 1;
//             }
//         }
//         int ans = 0;
//         for (int i = 0; i < 32; ++i) {
//             if (bit[i] >= k) ans += 1 << i;
//         }
//         return ans;
//     }
// }
// [Better]
//  Clear and faster. 
// [Ming]
//  Early stop, less space, but slower... Nothing to say. 
class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int num : nums) {
                if (((num >> i) & 1) > 0) {
                    count++;
                    if (count >= k) {
                        ans += 1 << i;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
