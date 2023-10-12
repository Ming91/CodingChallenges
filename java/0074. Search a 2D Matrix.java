// Top Interview 150 Binary Search Q2
// Daily Challenge 08/07/2023
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length - 1;
        int n = matrix[0].length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (matrix[l][0] > target) {
            return false;
        }
        int row = l;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[row][l] == target;
    }
}
// [Top Interview][Ming]
//  Use last of each row to find the first row. Can also solved the first apperance problem.

// [Editorial]
//  Unfold the matrix to a 1-D array. [i, j] -> [m * i + j], bottleneck is the mod and divide. 

// [Top Interview][Ming]
//  Use first of each row to find the row. Works, but not guaranteed to be the first apperance row,
//  since could be [1, 2, 2][2, 2, 3]

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int l = 0;
//         int r = matrix.length - 1;
//         while (l < r) {
//             int mid = (l + r + 1) / 2;
//             if (matrix[mid][0] > target) {
//                 r = mid - 1;
//             } else {
//                 l = mid;
//             }
//         }
//         if (matrix[r][0] == target) {
//             return true;
//         }
//         int row = r;
//         l = 0;
//         r = matrix[0].length - 1;
//         while (l < r) {
//             int mid = (l + r) / 2;
//             if (matrix[row][mid] < target) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return matrix[row][l] == target;
//     }
// }

// Daily Challenge 08/07/2023
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int rowL = 0, rowR = m - 1;
//         int colL = 0, colR = n - 1;
//         while (rowL < rowR) {
//             int rowMid = (rowL + rowR + 1) >> 1;
//             if (matrix[rowMid][0] <= target) {
//                 rowL = rowMid;
//             } else {
//                 rowR = rowMid - 1;
//             }
//         }
//         if (matrix[rowL][n - 1] < target) {
//             return false;
//         }
//         while (colL < colR) {
//             int colMid = (colL + colR) >> 1;
//             if (matrix[rowL][colMid] < target) {
//                 colL = colMid + 1;
//             } else {
//                 if (matrix[rowL][colMid] == target) {
//                     return true;
//                 } else {
//                     colR = colMid;
//                 }
//             }
//         }
//         return matrix[rowL][colL] == target;
//     }
// }
