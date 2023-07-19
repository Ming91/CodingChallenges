class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return 0;
        }
        int max = -50_000;
        int min = 50_000;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[1]);
            max = Math.max(max, interval[1]);
        }
        // 必须在min前有一位,
        // 这样保证start小于min的会被处理为0,
        // start为min的是1,这样有所区分,为1的仍可以在第一个区间后加入,
        // 但是0的不可以
        int[] largestStart = new int[max - min + 2];
        for (int[] interval : intervals) {
            int start = interval[0] - min + 1;
            int end = interval[1] - min + 1;
            if (start > largestStart[end]) {
                largestStart[end] = start;
            }
        }
        int currentStart = 1;
        int ans = n - 1;
        for (int i = 2; i < max - min + 2; i++) {
            if (currentStart <= largestStart[i]) {
                ans--;
                currentStart = i;
            }
        }
        return ans;
    }
}

// beat 99%的想法:
// 空间换时间,不排序
// 在min max区间内找到各个时间点最晚的起始点
// 例如[1, 3] [2, 3],则largestStart[3] = 2;
// 这样从min遍历到max,如果start<largestStart[i],则ans++, start = i;

// 经典问题，忘记了。。。
// 看到greedy后想起来了
// 按结束时间排序，然后遍历，如果开始时间不小于目前结束时间,ans++

// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         int n = intervals.length;
//         if (n < 2) {
//             return 0;
//         }
//         Arrays.sort(intervals, Comparator
//                                 .comparingInt((int[] a) -> a[1]));
//                                 // .thenComparingInt(a -> a[0]));
        
//         //int currentStart = intervals[0][0];
//         int currentEnd = intervals[0][1];
//         int ans = 1;
//         int i = 1;
//         while (i < n) {
//             // while (i < n && intervals[i][0] == currentStart) {
//             //     i++;
//             // }
//             while (i < n && intervals[i][0] < currentEnd) {
//                 i++;
//             }
//             if (i < n) {
//                 //currentStart = intervals[i][0];
//                 currentEnd = intervals[i][1];
//                 ans++;
//             }
//         }
        
//         return n - ans;
//     }
// }
