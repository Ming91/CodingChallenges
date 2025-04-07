// Top Interview 150 Graph General Q6
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[0]]++;
        }
        int count = 0;
        boolean updated = true;
        int m = prerequisites.length;
        boolean[] visited = new boolean[m];
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                ans[count++] = i;
            }
        }
        while (updated) {
            updated = false;
            for (int i = 0; i < m; i++) {
                if (visited[i] || degree[prerequisites[i][1]] > 0) {
                    continue;
                }
                updated = true;
                visited[i] = true;
                degree[prerequisites[i][0]]--;
                if (degree[prerequisites[i][0]] == 0) {
                    ans[count++] = prerequisites[i][0];
                }
            }
        }
        if (count < numCourses) {
            return new int[0];
        }
        return ans;
    }
}
// Just like #207, but more prerequisites numbers. 
// So Beat 99% solution of 207 is slow in this problem.
