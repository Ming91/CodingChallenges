// Daily Challenge 08/06/2023
class Solution {
    static final int MOD = 1_000_000_007;
    static long[] factorial = new long[101];
    static long[] invFactor = new long[101];
    void calcFactor(int n) {
        if (factorial[n] > 0) {
            return ;
        }
        factorial[0] = 1;
        invFactor[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
            // Fermat's Little Theorem:
            // p是质数, 则a^p = a (mod p), ap互质, 则a^(p - 1) = 1 (mod p)

            // inv * n! = 1 则 inv * n! = 1 = n!^(p - 1) (mod p)
            
            // ac = bc (mod p)时, 若c p互质, 则a = b(mod p)
            //      因为 (a - b)c = kp, cp互质, 则a-b为p的倍数, a=b(mod p)

            // 则 inv = n!^(p - 2) (mod p)
            invFactor[i] = power(factorial[i], MOD - 2);
        }
    }
    long power(long base, int exp) {
        // 用二进制方法算power
        //  例如7 = 111, (n^1) * (n^2) * (n^4)
        long ans = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base) % MOD;
            }
            exp >>= 1;
            base = (base * base) % MOD; 
        }
        return ans;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        long ans = 0;
        calcFactor(n);
        int sign = 1;
        for (int i = n; i >= k + 1; i--) {
            long temp = power(i - k, goal - k);
            temp = (temp * invFactor[n - i]) % MOD;
            temp = (temp * invFactor[i - k]) % MOD;
            ans = (ans + sign * temp + MOD) % MOD;
            sign = -sign;
        }
        ans = (ans * factorial[n]) % MOD;
        return (int) ans;
    }
}
// 设f(x)为goal长度, x个不同歌曲的组合的个数, x为(k, n]
//      题目要求n在(k, goal]
//  前k个数, 有x - i种选择, 第k+1个数开始, 有(x - k)个选择
//  f(x) = x * (x-1) * (x-2)*...*(x - k + 1) * (x - k) * (x - k) *...
//       = x!/(x - k)! * (x - k)^(goal - k)
//  从这里可以看出,x<=k的时候, f为0, 因此后面的项可以帮助推导公式, 但计算中可省略
//  但是重复计算了, 例如f(4)里面, 不同个数为3, 不同个数为2的内容, 假设k=2(或者1)
//  初步想f(4) - C(4, 3) * f(3)
//  f(3)里面也有2的内容, 而且4选3的时候, abc和abd两种都会包含ab这一组两次,因此正确答案为
//  C(4, 4)f(4) - C(4, 3) * f(3) + C(4, 2)f(2)
//  ans = Sum[i = n ~ k] { (-1)^(n - i) * C(n, i) * i! / (i - k)! * (i - k) ^(goal - k)}
//      = Sum{(-1)^(n - i) * n! * (i - k)^(goal - k) / (n - i)!(i - k)!  }

// class Solution {
//     static final int MOD = 1_000_000_007;
//     public int numMusicPlaylists(int n, int goal, int k) {
//         long[][] dp = new long[goal + 1][n + 1];
//         dp[0][0] = 1;
//         for (int i = 1; i <= goal; i++) {
//             for (int j = 1; j <= i && j <= n; j++) {
//                 dp[i][j] = dp[i - 1][j - 1] * (n - j + 1);
//                 while (dp[i][j] > MOD) {
//                     dp[i][j] -= MOD;
//                 }
//                 if (j > k) {
//                     dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k));
//                     while (dp[i][j] > MOD) {
//                         dp[i][j] -= MOD;
//                     }
//                 }
//             }
//         }
//         return (int)dp[goal][n];
//     }
// }

// 尝试用backtrack, 结果tle而且结果也不对(没mod 100_000_007)
