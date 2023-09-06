// Daily Question 09/01/2023
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int end = n >> 1;
        for (int i = 0; i <= end; i++) {
            int j = i << 1;
            ans[j] = ans[i];
            if (j == n) {
                return ans;
            }
            ans[j + 1] = ans[i] + 1;
            
        }
        // for (int i = 1; i <= n; i++) {
        //     ans[i] = ans[i & (i - 1)] + 1;
        //     ans[i] = Integer.bitCount(i);
        // }
        return ans;
    }
}
// Techniques:
//  0. HD, JDK bintCount use <Hacer's Delight> method,
//      divide and conquer method. Use ops, save 1s in every 2, 4, 6 ... 32 bit.
//  1. x &= x - 1; => remove 1s from right to left
//  2. add 1 to the right of previous numbers:
//      P(x + b) = P(x) + 1, b = 2^m > x. eg. P(3 + 4) = P(3) + 1, b = 2^2
//  3. add 1 or 0 to the most right bit
//      P(x) = p(x >> 1) + (x & 1), (1010) = (101) + (0)
//  4. use formular in 1, P(x) = P(x & (x - 1)) + 1;
//  5. 
