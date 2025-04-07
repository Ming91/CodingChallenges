// Weekly Contest 360 Q2
class Solution {
    public int minimumPossibleSum(int n, int target) {
        long mid = target >> 1;
        long ans = 0;
        if (n <= mid) {
            ans = ((long)n + 1) * n % 1_000_000_007 / 2;
            return (int)ans;
        }
        ans = ((long)mid + 1) * mid / 2 % 1_000_000_007;
        ans+= ((long)target + target + n - mid - 1) * (n - mid) / 2 % 1_000_000_007;
        return (int)(ans % 1_000_000_007);
    }
}
// 10^9 input, use math method [1, target / 2], [target, target + n - target / 2 - 1]

// previous problem version sim and check
// class Solution {
//     public long minimumPossibleSum(int n, int target) {
//         int curr = 1;
//         boolean[] p = new boolean[1_000_000];
//         long sum = 0;
//         for (int i = 0; i < n; i++) {
//             while (target - curr >= 0 && p[target - curr]) {
//                 curr++;
//             }
//             sum += curr;
//             p[curr] = true;
//             curr++;
//         }
//         return sum;
//     }
// }
