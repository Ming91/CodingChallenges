// LeetCode 75 Binary Search Q4

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        // After update r with piles irrelevant, we can skip sort
        // Arrays.sort(piles);
        // if (n == h) {
        //     return piles[n - 1];
        // }
        long sum = 0L;
        // int max = 0;
        for (int pile : piles) {
            sum += pile;
            // max = Math.max(max, pile);
        }
        // get max is slower.
        // if (n == h) {
        //     return max;
        // }
        int l = (int) ((sum + h - 1) / h);
        // n piles need at least n hours, (h - n + 1) remaining hours for last pile
        // sum - n + 1 remaining bananas
        int r = (int) ((sum + h + 1 - (n << 1)) / (h - n + 1)); 
        // r = Math.min(max, r);
        while (l < r) {
            int mid = (l + r) >> 1;
            // don't use function, same copy time
            int time = 0;
            for (int num : piles) {
                time += (num + mid - 1) / mid;
            }
            if (time > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
// upgrade the upper bound estimation, so sort is not needed.
// don't use function, save the copy time

// worst case [a, a, a ....a] * 10^4, all same number pile, can be a large upper bound,
//  use max as upper bound in this case

// use sort and binary search with instinct
// class Solution {
//     int calcTime(int[] nums, int target) {
//         int ans = 0;
//         for (int num : nums) {
//             ans += (num + target - 1) / target;
//         }
//         return ans;
//     }
//     public int minEatingSpeed(int[] piles, int h) {
//         int n = piles.length;
//         Arrays.sort(piles);
//         if (n == h) {
//             return piles[n - 1];
//         }
//         long sum = 0L;
//         for (int pile : piles) {
//             sum += pile;
//         }
//         int l = (int) ((sum + h - 1) / h);
//         // n piles need at least n hours, (h - n + 1) remaining hours for last pile
//         // sum - n + 1 is remaining bananas
//         int r = (int) ((sum + h + 1 - (n << 1)) / (h - n + 1));    
//         // int r = piles[n - 1];
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             if (calcTime(piles, mid) > h) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
// }
