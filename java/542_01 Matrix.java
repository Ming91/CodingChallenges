// Daily Challenge 08/17/2023
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        mat[0][0] = mat[0][0] == 0 ? 0 : m + n - 2;
        for (int j = 1; j < n; j++) {
            mat[0][j] = mat[0][j] == 0 ? 0 : mat[0][j - 1] + 1;
        }
        for (int i = 1; i < m; i++) {
            mat[i][0] = mat[i][0] == 0 ? 0 : mat[i - 1][0] + 1;
            for (int j = 1; j < n; j++) {
                mat[i][j] = mat[i][j] == 0 ? 0 : Math.min(mat[i - 1][j], mat[i][j - 1]) + 1;
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            // mat[m - 1][j] = mat[m - 1][j] == 0 ? 0 : Math.min(mat[m - 1][j], mat[m - 1][j + 1] + 1);
            mat[m - 1][j] = Math.min(mat[m - 1][j], mat[m - 1][j + 1] + 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            // mat[i][n - 1] = mat[i][n - 1] == 0 ? 0 : Math.min(mat[i][n - 1], mat[i + 1][n - 1] + 1);
            mat[i][n - 1] = Math.min(mat[i][n - 1], mat[i + 1][n - 1] + 1);
            for (int j = n - 2; j >= 0; j--) {
                mat[i][j] = mat[i][j] == 0 ? 0 : Math.min(mat[i][j], Math.min(mat[i + 1][j], mat[i][j + 1]) + 1);
            }
        }
        return mat;
    }
}
// dp down right + up left, two iterates
// need practice more.

// BFS

// class Solution {
//     static final int[][] DIR = new int[][] {
//         {0, 1}, {0, -1},
//         {1, 0}, {-1, 0}
//     };
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         Queue<List<Integer>> q = new LinkedList<>();
//         boolean[][] visited = new boolean[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (mat[i][j] == 0) {
//                     visited[i][j] = true;
//                     q.add(List.of(i, j));
//                 }
//             }
//         }
//         int dist = 1;
//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 List<Integer> curr = q.poll();
//                 int x = curr.get(0), y = curr.get(1);
//                 for (int[] d : DIR) {
//                     int xx = x + d[0], yy = y + d[1];
//                     if (xx < m && xx >= 0 && 
//                         yy < n && yy >= 0 &&
//                         !visited[xx][yy]) {
//                             mat[xx][yy] = dist;
//                             visited[xx][yy] = true;
//                             q.offer(List.of(xx, yy));
//                         }
//                 }
//             }
//             dist++;
//         }
//         return mat;
//     }
// }
