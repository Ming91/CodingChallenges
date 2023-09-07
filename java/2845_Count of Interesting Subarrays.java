// Weekly Contest 361 Q3
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // prefixI - prefixJ = k means [j + 1, i] valid count = k.
        // prefixSumCount[0] = 1 means when [0, i] count = k, ans add 1.
        prefixSumCount.put(0, 1);
        long ans = 0;
        int n = nums.size();
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num % modulo == k ? 1 : 0;
            int r1 = (prefixSum - k) % modulo;
            int r2 = prefixSum % modulo;
            long pairCount = prefixSumCount.getOrDefault(r1, 0);
            ans += pairCount;
            prefixSumCount.put(r2, prefixSumCount.getOrDefault(r2, 0) + 1);
        }
        return ans;
    }
}
// [Ming] stupid interval count
// class Solution {
//     public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
//         int n = nums.size();
//         System.out.println(n);
//         if (modulo == 1) {
//             return (long)n * (n + 1) / 2;
//         } 
//         boolean[] mod = new boolean[n];
//         int valid = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums.get(i) % modulo == k) {
//                 mod[i] = true;
//                 valid++;
//             }
//         }
//         long[] validIdx = new long[valid];
//         int len = 0;
//         for (int i = 0; i < n; i++) {
//             if (mod[i]) {
//                 validIdx[len++] = i;
//             }
//         }
//         long step = k;
//         long ans = 0;
//         if (step == 0) {
//             if (valid == 0) {
//                 return ((long)n * (n + 1)) / 2;
//             }
//             long val = validIdx[0];
//             ans += (val * val + val) / 2;
//             // System.out.println(ans);
//             for (int i = 1; i < valid; i++) {
//                 val = validIdx[i] - validIdx[i - 1] - 1;
//                 ans += (val + 1) * val / 2;
//             }
//             // System.out.println(ans);
//             val = (n - validIdx[valid - 1] - 1);
//             ans += (val + 1) * val / 2;
//             // System.out.println(ans);
//             step += modulo;
//         }
//         if (valid < step) {
//             return ans;
//         }
//         while (step <= valid) {
//             int l = 0, r = (int)(step - 1);
//             while (r < valid) {
//                 long left = 1, right = 1;
//                 if (l == 0) {
//                     left = validIdx[0] + 1;
//                 } else {
//                     left = validIdx[l] - validIdx[l - 1];
//                 }
//                 if (r == valid - 1) {
//                     right = n - validIdx[valid - 1];
//                 } else {
//                     right = validIdx[r + 1] - validIdx[r];
//                 }
//                 l++;
//                 r++;
//                 ans += left * right;
//             }
//             step += modulo;
//         }
//         return ans;
//     }
// }
