// LeetCode 75 Binary Search Q2
// class Solution {
//     public int[] successfulPairs(int[] spells, int[] potions, long success) {
//         int n = spells.length;
//         int m = potions.length;
//         int maxP = 0;
//         int minP = spells[0];
//         for (int potion : potions) {
//             maxP = Math.max(maxP, potion);
//             minP = Math.min(minP, potion);
//         }
//         int[] count = new int[maxP - minP + 1];
//         for (int potion : potions) {
//             count[potion - minP]++;
//         }
//         for (int i = maxP - minP - 1; i >= 0; i--) {
//             count[i] += count[i + 1];
//         }
//         int[] ans = new int[n];
//         int i = 0;
//         for (int sp : spells) {
//             long target = Math.min((success + sp - 1) / sp, maxP + 1);
//             if (target > maxP) {
//                 i++;
//                 continue;
//             }
//             if (target < minP) {
//                 ans[i++] += count[0];
//                 continue;
//             }
//             ans[i++] = target > maxP ? 0 : count[(int)target - minP];
//         }
//         return ans;
//     }
// }
// count sort, more space for time

// sort both nlogn + mlogm vs (n + m)logm
class Solution {
    int bs(int[] nums, long t, long product, int p) {
        int l = 0;
        int r = p;
        t = (product + t - 1) / t;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < t) {
                l = mid + 1;
            } else {
                // if (nums[mid] == t) {
                //     return mid;
                // }
                r = mid;
            }
        }
        return l;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        if (m > n) {
            int[][] sortedSpell = new int[n][2];
            for (int i = 0; i < n; i++) {
                sortedSpell[i][0] = spells[i];
                sortedSpell[i][1] = i;
            }
            Arrays.sort(potions);
            Arrays.sort(sortedSpell, (a, b) -> (a[0] - b[0]));
            int currIdx = m;
            for (int i = 0; i < n; i++) {
                currIdx = bs(potions, sortedSpell[i][0], success, currIdx);
                ans[sortedSpell[i][1]] = m - currIdx;
            }
            return ans;

        } else {
            Arrays.sort(potions);
            for (int i = 0; i < n; i++) {
                ans[i] = m - bs(potions, spells[i], success, m);
            }
            return ans;
        }
    }        
}

// sort one arr, iterate another (n + m)logm
// class Solution {
//     int bs(int[] nums, long t, long product) {
//         int l = 0;
//         int r = nums.length;
//         t = (product + t - 1) / t;
//         while (l < r) {
//             int mid = (l + r) >> 1;
//             if (nums[mid] < t) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
//     public int[] successfulPairs(int[] spells, int[] potions, long success) {
//         int n = spells.length;
//         int m = potions.length;
//         int[] ans = new int[n];
//         Arrays.sort(potions);
//         for (int i = 0; i < n; i++) {
//             ans[i] = m - bs(potions, spells[i], success);
//         }
//         return ans;
//     }
// }
