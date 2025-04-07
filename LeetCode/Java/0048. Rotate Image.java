// Top Interview 150 Matrix Q3
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
            
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        // if ((n & 1) == 1) {
        //     for (int i = 0; i < n / 2; i++) {
        //         int j = n / 2;
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[n - j - 1][i];
        //         matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        //         matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        //         matrix[j][n - i - 1] = temp;
        //     }
        // }
        return ;
    }
}
