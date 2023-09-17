// Top Interview 150 Intervals Q2
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int l = intervals[0][0], r = intervals[0][1];
        int len = 0;
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start <= r) {
                r = Math.max(r, end);
            } else {
                intervals[len][0] = l;
                intervals[len++][1] = r;
                l = start;
                r = end;
            }
        }
        intervals[len][0] = l;
        intervals[len++][1] = r;
        // int[][] ans = res.stream()
        //                  .map(innerList -> innerList.stream()
        //                                             .mapToInt(Integer::intValue)
        //                                             .toArray())
        //                  .toArray(int[][]::new);
        return Arrays.copyOfRange(intervals, 0, len);
    }
}
// return int[][] is actually the key part
// can use List<int[]> and List.toArray(new int[k][]);
// k <= list.size() will increase automatically,
// k > list.size() will have null rows 
