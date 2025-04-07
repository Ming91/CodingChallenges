// Daily Question 09/24/2023
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] cap = new double[101];
        cap[0] = (double) poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i - 1; j >= 0; j--) {
                double spill = cap[j] - 1;
                if (spill > 0) {
                    cap[j] = spill / 2;
                    cap[j + 1] += spill / 2;
                } else {
                    cap[j] = 0;
                }
            }
        }
        return cap[query_glass] > 1 ? 1 : cap[query_glass];
    }
}
// [Beat 99%]
//  use 1-D array rather than 2D. 
//  [i, j] -> [i + 1, j] and [i + 1, j + 1]
//  so, we need to iterate j from i - 1 to 0, so updated j won't effect j - 1. 
//  eg. if from 0 to i, [0] -> [0] and [1], now [1] is updated and we can't get right [1] and [2]. 

// Very good question. 
// [Editorial] Just sim~~~~~~~~~
// class Solution {
//     public double champagneTower(int poured, int query_row, int query_glass) {
//         double[][] cap = new double[101][101];
//         cap[0][0] = (double) poured;
//         for (int i = 1; i <= query_row; i++) {
//             for (int j = 0; j <= i; j++) {
//                 double left = j == 0 ? 0 : cap[i - 1][j - 1] - 1;
//                 double right = j == i ? 0 : cap[i - 1][j] - 1;
//                 cap[i][j] += left > 0 ? left / 2 : 0;
//                 cap[i][j] += right > 0 ? right / 2 : 0;
//                 // System.out.print(cap[i][j] + ",");
//             }
//             // System.out.println();
//         }
//         return cap[query_row][query_glass] > 1 ? 1.0 : cap[query_row][query_glass];
//     }
// }
