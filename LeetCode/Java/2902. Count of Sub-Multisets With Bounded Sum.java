// Biweekly Contest 115 Q4
class Solution {
    static final int MOD = 1_000_000_007;
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0;
        for (int num : nums) {
            total += num;
            if (num <= r) {
                count.merge(num, 1, Integer::sum);
            }
        }
        if (total < l) {
            return 0;
        }
        r = Math.min(r, total);
        int[] dp = new int[r + 1];
        dp[0] = count.getOrDefault(0, 0) + 1;
        count.remove(Integer.valueOf(0));
        int sum = 0;
        // TLE
        // for (Map.Entry<Integer, Integer> e : count.entrySet()) {
        //     int num = e.getKey();
        //     int c = e.getValue();
        //     if (sum < r) {
        //         sum = Math.min(sum + c * num, r);
        //     }
        //     for (int i = sum; i >= num; i--) {
        //         int cc = c;
        //         for (int j = num; j <= i && cc > 0; j += num) {
        //             dp[i] += dp[i - j];
        //             dp[i] %= MOD;
        //             cc--;
        //         }
        //     }
        // }
        // Prefix version
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int num = e.getKey();
            int c = e.getValue();
            // if (sum < r) {
                sum = Math.min(sum + c * num, r);
            // }
            // prefix part
            // dp[i] = dp[i] + dp[i - num] + ... + dp[i - c*num] + dp[i-(c+1)*num] + ... + dp[i % num]
            for (int i = num; i <= sum; i++) {
                dp[i] = (dp[i] + dp[i - num]) % MOD;
            }
            int temp = (c + 1) * num;
            // correction part 
            // subtract dp[i - (freq + 1) * num] to the end part. 
            // leves dp[i] = dp[i] + dp[i-num] +...+ dp[i - c*num];
            for (int i = sum; i >= temp; i--) {
                dp[i] = (dp[i] - dp[i - temp] + MOD) % MOD;
            }
            // System.out.println(Arrays.toString(dp));
        }
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans += dp[i];
            ans %= MOD;
        }
        return ans;
    }
}
// [jeffreyhu8] 
//  https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/solutions/4168064/optimized-dynamic-programming/
// Use prefix sum to speed up. 

// [Ming] DP transformation is simple:
// dp[i][sum] = sum()dp[i - 1][sum - k * num]
// dp[i][sum] = dp[i-1][sum] + dp[i-1][sum-num] + ... + dp[i-1][sum-k*num]
// ... 
// dp[i][num] = dp[i-1][num] + dp[i-1][0]
// but when k is large, this could be slow and many waste.

// Let's use GPT to explain:
// Given that the number is repeated `freq` times, the transformation is:
// `dp[i] = dp[i] + dp[i - num] + dp[i - 2 * num] + ... + dp[i - freq * num]`

// This represents adding the number `num` 0 times, 1 time, 2 times, ... up to `freq` times to the possible sums we've already found.

// ### Prefix Sum Transformation:

// If we think of `dp[]` as a prefix sum array, the transformation changes.

// Let's assume that `dp[i]` includes the count up to `i - num`, then:

// `dp[i] += dp[i - num]`

// This operation effectively computes:
// `dp[i] = dp[i] + dp[i - num] + dp[i - 2 * num] + ...`

// because `dp[i - num]` already includes the counts of the previous numbers in it due to the prefix sum nature of `dp[]`.

// ### Correcting Over-Count:

// For sums that use the number more than `freq` times, we have to subtract the overcount. Since `dp[]` is a prefix sum, we can correct the overcount efficiently with:

// `dp[i] = dp[i] - dp[i - (freq + 1) * num]`

// This effectively subtracts all sums that were created by adding the number more than `freq` times.

// ### Why is this Efficient?

// Using `dp[]` as a prefix sum array allows for O(1) updates for each element in the array for a specific number. Rather than iterating and counting each possible combination, the prefix sum nature of `dp[]` automatically includes all previous combinations when a number is added.

// For each distinct number in the input list, we're able to update all possible sums in O(r) time, where `r` is the maximum sum we're considering. This is far faster than having nested loops to account for the multiplicity of each number in the input list.

// class Solution {
//     static final int MOD = 1_000_000_007;
//     int l, r, n;
//     int calc(Integer[][] dp, int[][] countArr, int idx, int sum) {
//         if (sum > r) {
//             return 0;
//         }
//         if (idx == n) {
//             if (sum >= l && sum <= r) {
//                 return 1;   
//             }
//             return 0;
//         }
//         if (dp[idx][sum] != null) {
//             return dp[idx][sum];
//         }
//         long res = 0;
//         int currNum = countArr[idx][0];
//         int currCount = countArr[idx][1];
//         if (currNum == 0) {
//             res = ((long)(currCount + 1) * calc(dp, countArr, idx + 1, sum)) % MOD;
//             dp[idx][sum] = (int)res;
//             return (int)res;
//         }
//         int currSum = sum;
//         for (int i = 0; i <= currCount; i++) {
//             res = (res + calc(dp, countArr, idx + 1, currSum)) % MOD;
//             currSum += currNum;
//         }
//         dp[idx][sum] = (int)res;
//         return (int)res;
//     }
//     public int countSubMultisets(List<Integer> nums, int l, int r) {
//         this.l = l;
//         this.r = r;
//         Map<Integer, Integer> count = new HashMap<>();
//         for (int num : nums) {
//             if (num <= r) {
//                 count.put(num, count.getOrDefault(num, 0) + 1);
//             }
//         }
//         // System.out.println(count);
//         // Set<Integer> set = new HashSet<>();
//         // for (int num : nums) {
//         //     set.add(num);
//         // }
//         // n = set.size();
//         n = count.size();
//         int i = 0;
//         int[][] countArr = new int[n][2];
//         for (Map.Entry<Integer, Integer> e : count.entrySet()) {
//             countArr[i][0] = e.getKey();
//             countArr[i][1] = e.getValue();
//             i++;
//         }
//         // System.out.println(Arrays.deepToString(countArr));
//         Integer[][] dp = new Integer[n + 1][r + 1];
//         return calc(dp, countArr, 0, 0);
//     }
// }
