// Weekly Contest 366 Q2
class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        // Integer[] pt = processorTime.toArray(new Integer[0]);
        // Integer[] t = tasks.toArray(new Integer[0]);
        // Arrays.sort(pt);
        // Arrays.sort(t);
        // int n = pt.length;;
        int n = processorTime.size();
        int ans = 0;
        int m = 4 * n;
        int i = 0;
        int j = m - 1;
        while (i < n) {
            int res = processorTime.get(i) + tasks.get(j);
            ans = Math.max(ans, res);
            j -= 4;
            i++;
        }

        return ans;
    }
}
