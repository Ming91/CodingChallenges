// Daily Question 10/23/2023
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        // [Ming] Loop version.
        // while (n > 1) {
        //     if ((n & 3) > 0) {
        //         return false;
        //     }
        //     n >>>= 2;
        // }
        // return true;

        // [Editorial]Loop version.
        // while ((n & 3) == 0) {
        //     n >>= 2;
        // }
        // return n == 1;

        // [Ming] power version
        // int pow = (int)(Math.log(n) / Math.log(4));
        // return n == (int)Math.pow(4, pow);

        // [Editorial] power version
        //  But I think may not solid because the precision loss. 
        // return (Math.log(n) / Math.log(2) % 2 == 0);

        // [Editorial] Bit manipulation
        //      2^n check,      A = 1010, no odd power of n check. 
        // return ((n & (n - 1)) == 0) && ((n & 0xAAAAAAAA) == 0);

        // [Editorial] Bit + Math, great observation
        // First chekc n = 2 ^ a, 
        // Then if a = 2k,  [(3 + 1) ^ k] mod 3 = 1, 
        //         a = 2k + 1, [2 * (3 + 1) ^ k] mod 3 = 2.
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
