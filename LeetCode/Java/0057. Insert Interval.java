// Top Interview 150 Intervals Q3
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        // add intervals before added one
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i++]);
        }

        // find the overlap of curr interval and new one
        int l = 0, r = 0;

        // case 1: no overlapping
        // eg. [i - 1] [new] [i] or [n - 1] [new]
        if (i == n || newInterval[1] < intervals[i][0]) {
            l = newInterval[0];
            r = newInterval[1];
        } else {
            // case 2: overlapping, chose suitable start and end
            l = Math.min(newInterval[0], intervals[i][0]);
            r = Math.max(newInterval[1], intervals[i][1]);
            // find overlapping part right bound
            while (i < n && intervals[i][0] <= r) {
                r = Math.max(r, intervals[i++][1]);
            }
        }
        // add overlapping part to ans
        ans.add(new int[] {l, r});
        // add remaining intervals
        for (int j = i; j < n; j++) {
            ans.add(intervals[j]);
        }
        return ans.toArray(new int[0][]);
    }
}
