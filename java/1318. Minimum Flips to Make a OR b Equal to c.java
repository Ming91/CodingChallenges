// LeetCode 75 Bit Manipulation Q3
class Solution {
    public int minFlips(int a, int b, int c) {
        //                      a|b != c                        a,b,c = 1,1,0, need 2 ops
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount((a & b) & ~c);
        // int ans = 0;
        // while (a > 0 || b > 0 || c > 0) {
        //     int cc = c & 1;
        //     int aa = a & 1;
        //     int bb = b & 1;
        //     switch (cc) {
        //         case 0:
        //             ans += aa + bb;
        //             break;
        //         case 1:
        //             ans += 1 - (aa | bb);
        //     }
        //     c = c >> 1;
        //     b = b >> 1;
        //     a = a >> 1;
                
        // }
        // return ans;
    }
}
// +---+---+-----+-----+---+
// | a | b | a|b | c=0 | 1 |
// +---+---+-----+-----+---+
// | 0 | 0 |  0  |  0  | 1 |
// +---+---+-----+-----+---+
// | 0 | 1 |  1  |  1  | 0 |
// +---+---+-----+-----+---+
// | 1 | 0 |  1  |  1  | 0 |
// +---+---+-----+-----+---+
// | 1 | 1 |  1  |  2  | 0 |
// +---+---+-----+-----+---+
