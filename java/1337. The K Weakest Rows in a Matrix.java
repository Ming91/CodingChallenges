// Daily Question 09/18/2023
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[k];
        int count = 0;
        for (int j = 0; j < n && count < k; j++) {
            for (int i = 0; i < m && count < k; i++) {
                if ((mat[i][j] == 0) && (j == 0 || mat[i][j - 1] == 1)) {
                    ans[count++] = i;
                }
            }
        }
        for (int i = 0; i < m && count < k; i++) {
            if (mat[i][n - 1] == 1) {
                ans[count++] = i;
            }
        }
        return ans;
    }
}
// [Ming] Iterate by col. 
// eg. care [[1,1,1,1,1],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,0],[1,1,1,1,1]]
// need extra check to seperate [1...1] and [1..1, 0]

// [Ming] Count and sort
// class Solution {
//     public int[] kWeakestRows(int[][] mat, int k) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int[][] soldiers = new int[m][2];
//         for (int i = 0; i < m; i++) {
//             soldiers[i][1] = i;
//             for (int j = 0; j < n; j++) {
//                 if (mat[i][j] == 0) {
//                     break;
//                 }
//                 soldiers[i][0]++;
//             }
//         }
//         Arrays.sort(soldiers, (a, b) -> Integer.compare(a[0], b[0]));
//         int[] ans = new int[k];
//         for (int i = 0; i < k; i++) {
//             ans[i] = soldiers[i][1];
//         }
//         return ans;
//     }
// }
