// Daily Challenge 07/24/2023
class Solution {
    private double posPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double ans = posPow(x, Math.abs(n) >> 1);
        ans = ans * ans;
        if ((n & 1) == 1) {
            ans = x * ans;
        }
        return ans;

    }
    public double myPow(double x, int n) {
        double ans;
        if (n == Integer.MIN_VALUE) {
            ans = posPow(x, Math.abs(n + 1) >> 1);
        } else {
            ans = posPow(x, Math.abs(n) >> 1);
        }
        
        ans = ans * ans;
        if ((n & 1) == 1) {
            ans = x * ans;
        }
        if (n == Integer.MIN_VALUE) {
            ans = x * x * ans;
        }
        if (n < 0) {
            return 1 / ans;
        }
        return ans;
    }
}
// Math.abs(MIN_VALUE) = MIN_VALUE, 因为int或long的max比min的绝对值小1
// 例如-2^31 ~ 2^31 - 1;
// 复习补码: -2^31 = 0x8000 0000,
// 如果是8bit有符号,即 0000 0000 ~ 1111 1111, 为-128 ~ 127,
// 其实无符号为0 ~ 255, 运算看为结果mod 256即可,
// -128 与 128 对256 同模, -1 与 255 同模, 因此将128视为-128, 255视为-1, 没有影响
// // 甚至解释为其他的区间也可以,只是要补充说明
// x的补码就是(256 - x) + 1, 再补就是256 - (256 - x + 1) + 1 = x
