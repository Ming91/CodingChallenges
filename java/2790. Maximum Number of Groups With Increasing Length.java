// Weekly Contest 355 Q3
class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        if (n < 2) {
            return n;
        }
        Collections.sort(usageLimits);
        if (usageLimits.get(0) >= n) {
            return n;
        }
        int ans = 1;
        int total = 0;
        for (int num : usageLimits) {
            total += num;
            if (total >= ans) {
                total -= ans;
                ans++;
            }
        }
        return ans - 1;
    }
}
// [1, 2, 3, 4] 是合适的list
// 这样就从1开始,挨个往后扣减, 比如[1, 1, 1], 后面两个1可以当一个2来用

// 之前的想法是维护数列, 先找该减的数, 比其大的先减1, 再从此数最左边减起来
// 以此来保证order
// 2 2 3 3 6 7 原始
// 2 2 3 3 6 6 长度1
// 2 2 3 3 5 5 长度2
// 2 2 2 3 4 4 长度3
// 1 2 2 2 3 3 长度4
// 1 1 1 1 2 2 长度5
// 0 0 0 0 1 1 长度6

// TLE 2022/2025
// class Solution {
//     private int bs1(int idx, int[] nums) {
//         int l = 0;
//         int r = idx;
//         int pivot = nums[idx];
//         while (l < r) {
//             int mid = (l + r) / 2;
//             if (nums[mid] < pivot) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
//     private int bs2(int idx, int[] nums) {
//         int l = idx;
//         int r = nums.length - 1;
//         int pivot = nums[idx];
//         while (l < r) {
//             int mid = (l + r) / 2;
//             if (nums[mid] <= pivot) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
//     public int maxIncreasingGroups(List<Integer> usageLimits) {
//         int n = usageLimits.size();
//         if (n < 2) {
//             return n;
//         }
//         Collections.sort(usageLimits);
//         if (usageLimits.get(0) >= n) {
//             return n;
//         }
//         int idx = 0;
//         int[] prev = new int[n];
//         //int[] curr = new int[n];
//         for (int u : usageLimits) {
//             prev[idx++] = u;
//         }
//         int ans = 0;
//         // change [n - 1 - ans, n - 1], ans + 1 total
//         while (ans < n) {
//             if (prev[n - 1 - ans] == 0) {
//                 return ans;
//             }
//             int idx1 = bs1(n - 1 - ans, prev);
//             int idx2 = bs2(n - 1 - ans, prev);
//             // System.out.printf("%d, %d%n", idx1, idx2);
//             if (prev[idx2] == prev[n - 1 - ans]) {
//                 idx2++;
//             }
//             for (int i = idx2; i < n; i++) {
//                     prev[i]--;
//             }
//             for (int i = 0; i < ans + 1 - n + idx2; i++) {
//                     prev[i + idx1]--;
//             }
//             // if (idx2 == n - 1) {
//             //     for (int i = 0; i < ans + 1; i++) {
//             //         prev[i + idx1]--;
//             //     }
//             // } else {
//             //     for (int i = idx2; i < n; i++) {
//             //         prev[i]--;
//             //     }
//             //     for (int i = 0; i < ans + 1 - n - idx2; i++) {
//             //         prev[i + idx1]--;
//             //     }
//             // }
            
//             // for (int i = 0; i < n; i++) {
//             //     System.out.printf("%d,", prev[i]);
//             // }
//             // System.out.println();
//             ans++;
//         }
//         return ans;
//     }
// }
// 

// TLE 2019/2025
// class Solution {
//     public int maxIncreasingGroups(List<Integer> usageLimits) {
//         int n = usageLimits.size();
//         if (n < 2) {
//             return n;
//         }
//         Collections.sort(usageLimits);
//         if (usageLimits.get(0) >= n) {
//             return n;
//         }
//         int idx = 0;
//         // int[] l = new int[n];
//         // for (int u : usageLimits) {
//         //     l[idx++] = u;
//         // }
//         Queue<Integer> prev = new PriorityQueue<>(
//             (a, b) -> b - a
//         );
//         //Queue<Integer> curr = new PriorityQueue<>();
//         for (int u : usageLimits) {
//             prev.add(u);
//         }
//         int ans = 0;
//         while (prev.size() > ans) {
//             int[] temp = new int[ans + 1];
//             for (int i = 0; i <= ans; i++) {
//                 if (prev.peek() == 0) {
//                     return ans;
//                 } else {
//                     temp[i] = prev.poll() - 1;
//                 }
//             }
//             for (int i = 0; i <= ans; i++) {
//                 prev.add(temp[i]);
//             }
//             ans++;
//         }
//         return ans;
//     }
// }
