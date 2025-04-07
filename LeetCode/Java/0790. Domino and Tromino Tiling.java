// LeetCode 75 DP - 1D Q4
class Solution {
    static final int MOD = 1_000_000_007;
    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }
        long fullPrev = 2L, fullPrev2 = 1L;
        long partialPrev = 1L;
        for (int i = 3; i <= n; i++) {
            long full = (fullPrev + fullPrev2 + (partialPrev << 1)) % MOD;
            long partial = (partialPrev + fullPrev2) % MOD;
            fullPrev2 = fullPrev;
            fullPrev = full;
            partialPrev = partial;
        }
        return (int)fullPrev;
    }
}

// class Solution {
//     static final int MOD = (int)1e9 + 7;
//     public int numTilings(int n) {
//         if (n <= 2) {
//             return n;
//         }
//         long[] f = new long[n + 1];
//         long[] p = new long[n + 1];
//         f[1] = 1;
//         f[2] = 2;
//         p[2] = 1;
//         for (int i = 3; i <= n; i++) {
//             //     add 1 H    add 2 Ve       add 1 L
//             f[i] = (f[i - 1] + f[i - 2] + 2 * p[i - 1]) % MOD;
//             p[i] = (p[i - 1] + f[i - 2]) % MOD; 
//         }
//         return (int)f[n];
//     }
// }
// didn't figure it out by self
// f(x) = # of full when n = x. Like |||
// p(x) = # of partial when n = x; Like L
// f(x) = f(x - 1) + f(x - 2) + 2 * P(x - 1)
// p(x) = p(x - 1) + f(x - 2)

// matrix:
// |f(x)    |   |  1  1  2  |   |f(x - 1)|
// |f(x - 1)| = |  1  0  0  | * |f(x - 2)|
// |p(x)    |   |  0  1  1  |   |p(x - 1)|

// 给matrix对角化, 化简计算. 但是求得的是复空间, 待学习

// fibnonacci seq like optmization:
//  f(x) - f(x - 1) = f(x - 2) + 2 * p(x - 1)       (1)
//  f(x - 1) - f(x - 2) = f(x - 3) + 2 * p(x - 2)   (2)
//  (1) - (2) => f(x) = 2 * f(x - 1) + f(x - 3)

// important recall:
//  recurrence relation: an = f(an-1, an-2, ... ak);
//  eg. an = X * an-1 + Y * an-2
//     *** for each recurrsion, it times x and y, so a ***reasonable guess***
//          is an = r^n
//  so introuduce Characteristic Equation:
//      r^n = X*r^(n-1) + Y * r^(n-2)

//  for this problem:
//      x^3 = 2*x^2 + 1

//  more reading: cubic equation solve
//       general idea:  x^3 + bx^2 + cx + d = 0 => x^3 + px + q = 0
//       考虑图像左右平移, 拐点放在y轴, 即让二阶导数在x=0时候为0, 
//       然后在拐点p是斜率, 还可根据导数为0算出右侧最小值, 用q表示
//       之后就可以根据斜率和最小值的组合情况判断根的个数, 3个不同, 1个 + 2个相同, 3个相同, 1个+2共轭复根
//       共轭复根情况考虑x^3 - 8 = 0, 实根为2, 但是拐点在0, (x-2)((x + 1)^2 + 3) = 0,
//       
//  Cardano方法, (a + b)^3 - 左边展开 = 0, 然后(a+b) -> x, -3ab -> p, -(a^3 + b^3) -> q
//      求到1个实根, 然后除以(x - r)得到另外两个, 会用到复数

//  对此方程求根, 1实根2虚根为 -2/3 + sqrt3(43/54 + sqrt(59/108)) + sqrt3(43/54 - sqrt(59/108))
//  特征公式二次项的情况: 求得r1, r2, 则an = X r1^n + Y r2^n, 带入求满足的常数项
