// Daily Question 10/06/2023
class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        if (n % 3 == 0) {
            return (int)Math.pow(3, n / 3);
        }
        if (n % 3 == 1) {
            return (int)Math.pow(3, n / 3 - 1) * 4;
        }
        return (int)Math.pow(3, n / 3) * 2;
    }
}
// [Editorial]
//  Use Math.pow() rather than loop. 
// [Ming]
//  Math problem, f(k) = (n / k) ^ k. Derivative, and get k = n / e. So each part is 2 or 3. 
//  Use some n to test can find 3 is better. 
// class Solution {
//     public int integerBreak(int n) {
//         if (n == 2) {
//             return 1;
//         }
//         if (n == 3) {
//             return 2;
//         }
//         int ans = 1;
//         while (n > 4) {
//             ans *= 3;
//             n -= 3;
//         }
//         ans *= n;
//         return ans;
//     }
// }
