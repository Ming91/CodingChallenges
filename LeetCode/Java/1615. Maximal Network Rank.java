// Daily Challenge 08/18/2023
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int top1 = 0, top2 = 0, count1 = 0, count2 = 0;
        int[] degrees = new int[n];
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] > top1) {
                top2 = top1;
                top1 = degrees[i];
                continue;
            }
            if (degrees[i] > top2) {
                top2 = degrees[i];
            }
        }
        for (int degree : degrees) {
            if (degree == top1) {
                count1++;
                continue;
            }
            if (degree == top2) {
                count2++;
            }
        }
        int roadCount = 0;
        if (count1 > 1) {
            for (int[] road : roads) {
                if (degrees[road[0]] == top1 && degrees[road[1]] == top1) {
                    roadCount++;
                }
            }
            if (count1 * (count1 - 1) / 2 > roadCount) {
                return top1 << 1;
            }
            return (top1 << 1 ) - 1;
        }
        for (int road[] : roads) {
            if (degrees[road[0]] == top1 && degrees[road[1]] == top2 || 
                degrees[road[1]] == top1 && degrees[road[0]] == top2) {
                roadCount++;
            }
        }
        if (count2 > roadCount) {
            return top1 + top2;
        }
        return top1 + top2 - 1;

    }
}
// beat 99% idea: 
// 1. calc degree
// 2. get top1 and top2
// 3. calc top1 and top2 count
// 4. count1 > 1 then calculate how many edges connect top1 vertices
//   4.2 all fullly connectted if edge count = n * (n - 1)/2, then return top1*2-1
//   4.3 or return top1 * 2
// 5. count1 == 1, calculate how many edges connect top1 and top2,
//   5.2 edge count < count2, return top1 + top2
//   5.3 or reteurn top1 + top2 - 1

// iterate roads is fater than 2 loop for vertices

// stupid sort solution
// class Solution {
//     public int maximalNetworkRank(int n, int[][] roads) {
//         boolean[][] adj = new boolean[n][n];
//         int[][] degree = new int[n][2];
//         for (int[] road : roads) {
//             degree[road[0]][0]++;
//             degree[road[0]][1] = road[0];
//             degree[road[1]][0]++;
//             degree[road[1]][1] = road[1];
//             adj[road[0]][road[1]] = true;
//             adj[road[1]][road[0]] = true;
//         }
//         Arrays.sort(degree, (a, b) -> (b[0] - a[0]));
//         int ans = degree[0][0] + degree[1][0] - 1;
//         if (ans >= roads.length) {
//             return roads.length;
//         }
//         int i;
//         for (i = 0; i < n; i++) {
//             if (degree[i][0] < degree[0][0]) {
//                 break;
//             }
//         }
//         for (int ii = 0; ii < i; ii++) {
//             for (int jj = ii + 1; jj < i; jj++) {
//                 if (!adj[degree[ii][1]][degree[jj][1]]) {
//                     return ans + 1;
//                 }
//             }
//         }
//         if (i > 1) {
//             return ans;
//         }
//         for (i = 2; i < n; i++) {
//             if (degree[i][0] < degree[1][0]) {
//                 break;
//             }
//         }
//         for (int j = 1; j < i; j++) {
//             if (!adj[degree[0][1]][degree[j][1]]) {
//                 return ans + 1;
//             }
//         }
//         return ans;
//     }
// }
