// Daily Question 10/18/2023
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] degree = new int[n];
        List<Integer>[] nexts = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nexts[i] = new ArrayList<>();
        }
        for (int[] relation : relations) {
            degree[relation[1] - 1]++;
            nexts[relation[0] - 1].add(relation[1] - 1);
        }
        // Queue<Integer> q = new LinkedList<>();
        int[] qArr = new int[n];
        int tail = 0;
        int ans = 0;
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                endTime[i] = time[i];
                ans = Math.max(ans, endTime[i]);
                // q.add(i);
                qArr[tail++] = i;
            }
        }
        int head = 0;
        // while (!q.isEmpty()) {
        while (head < tail) {
            // int curr = q.poll();
            int curr = qArr[head++];
            for (int next : nexts[curr]) {
                degree[next]--;
                endTime[next] = Math.max(endTime[next], endTime[curr] + time[next]);
                ans = Math.max(ans, endTime[next]);
                if (degree[next] == 0) {
                    // q.add(next);
                    qArr[tail++] = next;
                }
            }
        }
        return ans;
    }
}
// [Ming] Topological sort. Using array as queue can be faster. 
// [Editorial] Find roots and dfs. 
