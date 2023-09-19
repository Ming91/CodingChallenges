// Biweekly Contest 109

class Solution {
    static final int base = 1_000_000_007;
    // private int bs(int n, int x) {
    //     int l = 1;
    //     int r = n;
    //     while (l < r) {
    //         int mid = (l + r) / 2;
    //         //System.out.println(l + "," + r);
    //         if (Math.pow(mid, x) <= n) {
    //             l = mid + 1;
    //         } else {
    //             r = mid;
    //         }
    //     }
    //     return l;
    // }
    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //int upper = bs(n, x) + 1;
        int upper = (int) Math.pow(n, (double)1 / x) + 1;
        // System.out.printf("%f%n", Math.pow(n, (double)1 / x));
        // System.out.println(upper);
        for (int i = 1; i <= upper; i++) {
            int p = 1;
            for (int j = 0; j < x; j++) {
                p *= i;
            }
            // bottom up!, update later ones
            // dp[m] = (dp[m] + dp[m - p]) % base;
            for (int j = n - p; j >= 0; j--) {
                if (dp[j] > 0){
                    // dp[j] is counts of comb [1, i - 1] with sum j
                    dp[j + p] = (dp[j + p] + dp[j]) % base;
                }
                
            }
        }
        
        return dp[n];
        // return 0;
    }
}
// beat 99% idea:
//  用1-d来存,看下方代码,也是i->i+1, 因此可以实现
//  i: 1~upper, dp[j]为[1~i-1]组合满足sum为j的count,因此到i时,用dp[j]更新dp[j+i^x]
//  注意顺序, 让j从大到小保证dp[j]用的是未更新前的值
//  
//  使用upper可以少检验, 但是因为j从n-i^x开始循环,省去的是计算i^x的时间
//  但是对比起来,upper用pow算较为快
//  但是有精度问题, floor(4.0)会是3,如果+1,有点失去意义
//  复习了浮点和long的表示,如果(int) double,会直接丢掉fraction
//  设想原理是这样的:sing*exp*fraction, fraction = sum(bi * 2^-i), i>exp的就丢掉,其余的处理并相加

// recursive dp after saw solution
// class Solution {
//     int[][] dp;
//     static final int base = 1_000_000_007;
//     private int calculateDP(int n, int i, int x) {
//         if (n == 0) {
//             return 0;
//         }
//         if (dp[n - 1][i - 1] >= 0) {
//             return dp[n - 1][i - 1];
//         }
//         int p = (int) Math.pow(i, x);
//         if (p > n) {
//             return 0;
//         }
//         if (p == n) {
//             return 1;
//         }

//         int select = calculateDP(n - p, i + 1, x) % base;
//         int skip = calculateDP(n, i + 1, x) % base;
//         int ans = (select + skip) % base;
//         dp[n - 1][i - 1] = ans;
//         return ans;
//     }
//     public int numberOfWays(int n, int x) {
//         dp = new int[n][n];
//         for (int[] d : dp) {
//             Arrays.fill(d, -1);
//         }
//         return calculateDP(n, 1, x);
//     }
// }
