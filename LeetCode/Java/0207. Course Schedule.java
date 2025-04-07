// Top Interview 150 Graph General Q5
// Top Interview 150 09/29/23 Impl
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
        }
        int count = 0;
        boolean updated = true;
        int m = prerequisites.length;
        boolean[] visited = new boolean[m];
        while (updated) {
            updated = false;
            for (int i = 0; i < m; i++) {
                if (visited[i] || degree[prerequisites[i][0]] > 0) {
                    continue;
                }
                updated = true;
                count++;
                visited[i] = true;
                degree[prerequisites[i][1]]--;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
// Impl the beat 99% idea. Think it's just because the test case.

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int[] inDegree = new int[numCourses];
//         Queue<Integer> q = new ArrayDeque<>();
//         List<Integer>[] child = new ArrayList[numCourses];
//         int visited = 0;
//         int numPre = prerequisites.length;
//         for (int i = 0; i < numCourses; i++) {
//             inDegree[i] = 0;
//             child[i] = new ArrayList<>();
//         }
//         for (int i = 0; i < numPre; i++) {
//             inDegree[prerequisites[i][1]]++;
//             child[prerequisites[i][0]].add(prerequisites[i][1]);
//         }
//         // don't forget this!!!
//         for (int i = 0; i < numCourses; i++) {
//             if (inDegree[i] == 0) {
//                 q.offer(i);
//             }
//         }
//         while (!q.isEmpty()) {
//             Integer current = q.poll();
//             visited++;
//             for (Integer c : child[current]) {
//                 inDegree[c]--;
//                 if (inDegree[c] == 0) {
//                     q.offer(c);
//                 }
//             }
//         }
//         // add this to improve mem rank
//         //System.gc();
//         if (visited < numCourses) {
//             return false;
//         }
//         return true;
//     }
// }
// 以上解法是topological sort using kahn's algo

// beat 99% 的解法是不用明显的queue，记录每个course入度（有多少前置）
// 循环prerequisites, 如果pre[i][0]入度为0，则修读此课程，pre[i][1]的入度--，flag置为true表示有更新，
// 同时此条pre记录为visited
// 最后判断是不是所有入度都为0了(是不是都没前置了)

// 官解dfs是找圈，自己的是找可行
// dfs, O(m+n) with O(m+n)
// class Solution {
//     List<Integer>[] parents;
//     boolean[] available;
//     boolean[] visited;
//     public boolean canTake(int course) {
//         if (available[course]) {
//             return true;
//         }
//         if (visited[course]) {
//             return false;
//         }
//         visited[course] = true;
//         if (parents[course].isEmpty()) {
//             available[course] = true;
//             return true;
//         }
//         for (Integer parent : parents[course]) {
//             if (available[parent]) {
//                 continue;
//             }
//             if (visited[parent] || !canTake(parent)) {
//                 available[course] = false;
//                 return false;
//             }
//         }
//         available[course] = true;
//         return true;
//     }
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         parents = new ArrayList[numCourses];
//         available = new boolean[numCourses];
//         visited = new boolean[numCourses];
//         //Queue<Integer> requiredCourses = new LinkedList<>();
//         int numPre = prerequisites.length;
//         for (int i = 0; i < numCourses; i++) {
//             parents[i] = new ArrayList<>();
//             available[i] = false;
//             visited[i] = false;
//         }
//         for (int i = 0; i < numPre; i++) {
//             parents[prerequisites[i][1]].add(prerequisites[i][0]);
//         }
//         for (int i = 0; i < numCourses; i++) {
//             if (canTake(i)) {
//                 continue;
//             }
//             return false;
//         }
//         return true;
//     }
// }
