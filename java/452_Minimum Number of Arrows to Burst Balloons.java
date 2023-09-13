// LeetCode 75 Intervals Q2
// Top Interview 150 Intervals Q4

// [TopInterview150] 09/13/2023 Impl Part 2
// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         int n = points.length;
//         long[] joined = new long[n];
//         int i = 0;
//         for (int[] point : points) {
//             joined[i++] = ((long)point[1] << 32) | (point[0] & 0xFFFF_FFFFL);
//         }
//         Arrays.sort(joined);
//         int ans = 0;
//         long x = Long.MIN_VALUE;
//         for (long j : joined) {
//             int start = (int)(j & (0xFFFF_FFFFL));
//             int end = (int)((j & 0xFFFF_FFFF_0000_0000L) >> 32);
//             // System.out.printf("%d, %d%n", start, end);
//             if (start > x) {
//                 ans++;
//                 x = end;
//             }
//         }
//         return ans;
//     }
// }
// [TopInterview150] 09/13/2023 Impl Part 1
// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
//         int n = points.length;
//         int ans = 1;
//         int i = 1;
//         int x = points[0][1];
//         while (i < n) {
//             if (points[i][0] > x) {
//                 ans++;
//                 x = points[i][1];
//             }
//             i++;
//         }
//         return ans;
//     }
// }

class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort Array by End
        // Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        // int ans = 1, shot = points[0][1];
        // for (int i = 1; i < points.length; i++) {
        //     if (shot < points[i][0]) {
        //         shot = points[i][1];
        //         ans++;
        //     }
        // }
        long[] p = new long[points.length];
        int n = 0;
        for (int[] point : points) {
            // if not add L at the end, when point[0] < 0, will effect point[1] sign to -1
            p[n++] = (((long)point[1] << 32) | (point[0] & 0xFFFF_FFFFL));
            // System.out.println((int)(p[n - 1] >> 32)+ "," + (int)(p[n - 1] & 0xFFFF_FFFFL));
        }
        // System.out.println((int)(0x1_FFFF_FFFFL & 0xFFFF_FFFFL));
        Arrays.sort(p);
        int ans = 1;
        int shot = (int)(p[0] >> 32);
        for (int i = 1; i < n; i++) {
            if (shot < (int)(p[i] & 0xFFFF_FFFF)) {
                shot = (int)(p[i] >> 32);
                ans++;
            }
        }
        return ans;
    }
}
// faster idea: combine two numbers and sort

// correct idea:
//  sort on end, shot on end

// why can shor on start?
//  Can shot, if inverse order start.
//  The point is, shot on start too early

// forgot this classic problem, 2nd time!!!
// naive intuition...
// sort on start, and some stupid modification

// class Solution {
//     public int findMinArrowShots(int[][] points) {

//         // cause overflow when a-b too large (eg. max - min)
//         // Arrays.sort(points, (a, b) -> {
//         //     if (a[0] == b[0]) {
//         //         return a[1] - b[1];
//         //     }
//         //     return a[0] - b[0];
//         // });
//         Arrays.sort(points, (a, b) -> {
//             if (Integer.valueOf(a[0]).equals(b[0])) {
//                 return Integer.compare(a[1], b[1]);
//             }
//             return Integer.compare(a[0], b[0]);
//         });
//         int ans = 1;
//         int shot = points[0][1];
//         for (int i = 0; i < points.length; i++) {
//             int[] point = points[i];
//             // System.out.println(shot + " " + point[0]);
//             if (point[0] > shot) {
//                 shot = point[1];
//                 ans++;
//             }
//             if (point[1] < shot) {
//                 shot = point[1];
//             }
//         }
//         return ans;
//     }
// }

