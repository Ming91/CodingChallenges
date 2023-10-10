// Weekly Contest 366 Q4
class Solution {
    static final int MOD = 1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i) & 1;
            }
        }
        long ans = 0;
        int[] optim = new int[k];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < k && j < count[i]; j++) {
                optim[j] |= (1 << i);
            }
        }
        for (int j = 0; j < k; j++) {
            ans = (ans + (long)optim[j] * optim[j]) % MOD;
        }
        // for (int j = 0; j < k; j++) {
        //     long res = 0;
        //     for (int i = 31; i >= 0; i--) {
        //         if (count[i] > 0) {
        //             res |= 1 << i;
        //             count[i]--;
        //         }
        //     }
        //     ans = (ans + res * res % MOD) % MOD;
        // }
        return (int)ans;
    }
}
// [Lee]
//  A or B means move '1' in A and B to a single number. 
//  So we need to count the 1 bits in [0 ~ 31] positions. 
//  And pick '1's with different positions that have count > 0 to form top k numbers. 

// [Beat 99%]
//  Instead generate each number and reduce count, 
//  the better way is to generate the number in advance with going through each count. 
