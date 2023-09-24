// Weekly Contest 364 Q2
class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long max = 0;
        for (int i = 0; i < n; i++) {
            int prev = maxHeights.get(i);
            long res = 0;
            for (int j = i; j >= 0; j--) {
                prev = Math.min(prev, maxHeights.get(j));
                res += prev;
            }
            prev = maxHeights.get(i);
            for (int j = i + 1; j < n; j++) {
                prev = Math.min(prev, maxHeights.get(j));
                res += prev;
            }
            max = Math.max(max, res);
        }
        return max;
    }
}
