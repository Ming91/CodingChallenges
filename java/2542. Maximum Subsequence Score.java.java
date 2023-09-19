// LeetCode 75 Heap / Priority Queue Q3
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long ans = 0;

        if (k == 1) {
            for (int i = 0; i < n; i++) {
                long cur = (long) nums1[i] * nums2[i];
                ans = Math.max(ans, cur);
            }
            return ans;
        }
        
        int[][] d = new int[n][2];
        for (int i = 0; i < n; i++) {
            d[i][0] = nums1[i];
            d[i][1] = nums2[i];
        }
        Arrays.sort(d, (a, b) -> (b[1] - a[1]));
        Queue<Integer> topK = new PriorityQueue<>();
        long topKSum = 0;
        for (int i = 0; i < k; i++) {
            topKSum += d[i][0];
            topK.add(d[i][0]);
        }
        ans = topKSum * d[k - 1][1];
        for (int i = k; i < n; i++) {
            if (topK.peek() < d[i][0]) {
                topKSum += d[i][0] - topK.poll();
                topK.add(d[i][0]);
            }
            ans = Math.max(ans, topKSum * d[i][1]);
        }
        return ans;
    }
}
// weird problem, min in nums2[] * sum in nums1[]
// order by nums2 and use queue to maintain the topKSum of nums1
