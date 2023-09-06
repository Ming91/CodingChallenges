// Daily Challenge 08/31/2023
class Solution {
    public int minTaps(int n, int[] ranges) {
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            int nextR = r;
            for (int i = l; i <= r + 100 && i <= n; i++) {
                if (i - ranges[i] <= r && nextR < i + ranges[i]) {
                    // nextL = i;
                    nextR = i + ranges[i];
                }
            }
            if (nextR == r) {
                // System.out.println(ans);
                return -1;
            }
            ans++;
            l = r + 1;
            r = nextR;
        }
        return ans;
    }
}
// Beat 99% idea:
//  no store for each maxReach, 
//  if curr interval [l, r], next interval is for i in [l, r + 100] since max width is 100
//  find the farest as next interval

// class Solution {
//     public int minTaps(int n, int[] ranges) {
//         int[] maxReach = new int[n + 1];
//         for (int i = 0; i <= n; i++) {
//             int start = Math.max(0, i - ranges[i]);
            
//             // End > n does not effect result, skip comparison
//             // int end = Math.min(n, i + ranges[i]);
//             int end = i + ranges[i];

//             // Later updated value of same start means larger i and ranges[i],
//             // so later updated end is always larger end. (wrong)
//             // But this is wrong, because start start from 0. eg.[4, 1, 1, 1, 1]
//             maxReach[start] = Math.max(maxReach[start], end);
//             // maxReach[start] = end;  
//         }
//         int curr = 0, next = 0;
//         int ans = 0;
//         for (int i = 0; i <= n; i++) {
//             if (next < i) {
//                 return -1;
//             }
//             if (curr < i) {
//                 ans++;
//                 curr = next;
//             }
//             next = Math.max(next, maxReach[i]);
//             // if (next == n) {
//             //     return ans + 1;
//             // }
//         }
//         return ans;
//     }
// }
// Still the same idea as max interval cover problem.
//  calculate the max reached point of each point.
// This problem need min value intervals, so use max end. 
//  The classic problem need max value, so use max start.

// [Hints]
// class Solution {
//     public int minTaps(int n, int[] ranges) {
//         int[][] intervals = new int[n + 1][2];
//         for (int i = 0; i <= n; i++) {
//             if (ranges[i] == 0) {
//                 intervals[i][0] = i;
//                 // intervals[i][1] = 0;
//                 continue;
//             }
//             intervals[i][0] = Math.max(0, i - ranges[i]);
//             intervals[i][1] = Math.min(n, i + ranges[i]);
//         }
//         Arrays.sort(intervals, (a, b) -> {
//             if (a[0] == b[0]) {
//                 return Integer.compare(b[1], a[1]);
//             } else {
//                 return Integer.compare(a[0], b[0]);
//             }
//         });
//         if (intervals[0][0] > 0) {
//             return -1;
//         }
//         // System.out.println(Arrays.deepToString(intervals));
//         int ans = 0;
//         int prev = 0;
//         int curr = intervals[0][1];
//         for (int i = 1; i <= n; i++) {
//             if (curr == n) {
//                 return ans + 1;
//             }
//             if (curr < intervals[i][0]) {
//                 // System.out.println(curr + "," + intervals[i][0] + "," + intervals[i][1]);
//                 return -1;
//             }
//             if (curr <intervals[i][1] ) {
                
//                 if (prev < intervals[i][0] && intervals[i][1] > 0) {
//                     ans++;
//                     prev = curr;
//                 }
                
//                 curr = intervals[i][1];
//             }
//         }
//         return ans;
//     }
// }
