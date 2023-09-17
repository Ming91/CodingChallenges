class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int topKSum = Integer.MIN_VALUE;
        int queueSize = 0;
        List<List<Integer>> ans = new ArrayList<>(k);
        Comparator comp = Comparator.comparing(
            (int[] l) -> (l[0])
        );
        Queue<int[]> pq = new PriorityQueue<>(comp);
        Set<List<Integer>> visited = new HashSet<>();
        pq.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(List.of(0, 0));
        //ans.add(List.of(nums1[0], nums2[0]));
        while (k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];

            ans.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < n && !visited.contains(List.of(i + 1, j))) {
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(List.of(i + 1, j));
            }
            if (j + 1 < m && !visited.contains(List.of(i, j + 1))) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(List.of(i, j + 1));
            }
            k--;
        }
        return ans;
    }
}
