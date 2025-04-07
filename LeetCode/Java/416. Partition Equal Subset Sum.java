// Daily Challenge 2025-04-07
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        // int n = nums.length;
        int m = sum / 2;
        int prev = 0;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        // Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        for (int num : nums) {
            // if (num > m) {
            //     break;
                // continue;
            // }
            // [Ming] Huge mistakes here, 
            //  1. wrong order causing all dp are true here.
            //  2. use wrong op, should use '|'
            // for (int i = 0; i < m - num && i <= prev; i++) {
            //     dp[i + num] = dp[i];
            // }
            prev += num;
            for (int i = Math.min(prev, m); i >= num; i--) {
                dp[i] |= dp[i - num];
            }
            if (dp[m]) {
                return true;
            }
        }
        return false;
    }
}
// [Ming] Initial set method
// class Solution {
//     public boolean canPartition(int[] nums) {
//         // int n = nums.length;
//         Set<Integer> sums = new HashSet<>();
//         // Set<Integer> added = new HashSet<>();
//         List<Integer> added = new ArrayList<>();
//         int sum = 0;
//         sums.add(0);
//         for (int num : nums) {
//             sum += num;
//         }
//         if ((sum & 1) == 1) {
//             return false;
//         }
//         sum /= 2;
//         for (int num : nums) {
//             for (int s : sums) {
//                 if (s + num == sum) {
//                     return true;
//                 }
//                 added.add(s + num);
//             }
//             for (int s : added) {
//                 sums.add(s);
//             }
//             added.clear();
//         }
//         return false;
//     }
// }