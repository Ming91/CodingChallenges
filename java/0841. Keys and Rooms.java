// LeetCode 75 Graphs - DFS Q1
class Solution {
    int len = 0;
    int n;
    void dfs(int curr, List<List<Integer>> rooms, boolean[] visited) {
        if (len == n) {
            return ;
        }
        if (visited[curr]) {
            return ;
        }
        visited[curr] = true;
        len++;
        for (Integer r : rooms.get(curr)) {
            dfs(r, rooms, visited);
        }
        return ;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        return len == n;
    }
}
// 用dfs, 更快

// 使用queue
// class Solution {
//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         int n = rooms.size();
//         boolean[] visited = new boolean[n];
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(0);
//         int len = 1;
//         visited[0] = true;
//         while (!q.isEmpty()) {
//             Integer room = q.poll();
//             List<Integer> keys = rooms.get(room);

//             for (Integer key : keys) {
//                 if (!visited[key]) {
//                     len++;
//                     visited[key] = true;
//                     q.offer(key);
//                 }
//                 if (len == n) {
//                     return true;
//                 }
//             }
//         }
//         return len == n;
//     }
// }
