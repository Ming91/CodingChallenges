// Daily Challenge 08/07/2023
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rowL = 0, rowR = m - 1;
        int colL = 0, colR = n - 1;
        while (rowL < rowR) {
            int rowMid = (rowL + rowR + 1) >> 1;
            if (matrix[rowMid][0] <= target) {
                rowL = rowMid;
            } else {
                rowR = rowMid - 1;
            }
        }
        if (matrix[rowL][n - 1] < target) {
            return false;
        }
        while (colL < colR) {
            int colMid = (colL + colR) >> 1;
            if (matrix[rowL][colMid] < target) {
                colL = colMid + 1;
            } else {
                if (matrix[rowL][colMid] == target) {
                    return true;
                } else {
                    colR = colMid;
                }
            }
        }
        return matrix[rowL][colL] == target;
    }
}
