// Daily Problem 10/29/2023
class Solution {
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x < 0) {
            return minKnightMoves(-x, y);
        }
        if (y < 0) {
            return minKnightMoves(x, -y);
        }
        if (x < y) {
            return minKnightMoves(y, x);
        }
        // if (x == 1 && y == 1) {
        if (x + y == 2) {
            // return 1 + minKnightMoves(x - 2, y + 1);
            return 2;
        }
        // if (x == 2 && y == 0) {
        //     // return 1 + minKnightMoves(x - 1, y + 2);
        //     return 2;
        // }
        if (x == 3 && y == 1) {
            // return 1 + minKnightMoves(x - 2, y + 1);
            return 2;
        }
        if (x == 4 && y == 3) {
            // return 1 + minKnightMoves(x - 1, y - 2);
            return 3;
        }
        return 1 + minKnightMoves(x - 2, y - 1);
    }
}
// [Beat 99%]
//  Patter from the map, 
//  [1, 1], [2, 0], [3, 1], [4, 3] are the only points can not get result from move [-2, -1]

// class Solution {
//     public int minKnightMoves(int x, int y) {
//         if (x == 0 && y == 0) {
//             return 0;
//         }
//         x = Math.abs(x);
//         y = Math.abs(y);
//         if (y > x) {
//             return minKnightMoves(y, x);
//         }
//         if (x == 1 && y == 0) {
//             return 3;
//         }
//         if (x == 2 && y == 2) {
//             return 4;
//         }
//         int delta = x - y;
//         if (y > delta) {
//             // notation: -5 / 3 = -1, must convert to float.
//             return delta - 2 * (int)Math.floor(((float)delta - y) / 3);
//         } else {
//             return delta - (delta - y) / 4 * 2;
//         }
//     }
// }
// [Pattern]
//  y > delta: delat - 2 * floor((delta - y) / 3)
//       else: delat - 2 * floor((delta - y) / 4)


// 10	11	10	11	10	11	10	11	10	11	10	11	12	11	12	13	12	13	14	13	14
// 11	10	11	10	11	10	11	10	11	10	11	10	11	12	11	12	13	12	13	14	13
// 10	9	10	9	10	9	10	9	10	9	10	11	10	11	12	11	12	13	12	13	14
// 9	10	9	10	9	10	9	10	9	10	9	10	11	10	11	12	11	12	13	12	13
// 8	9	8	9	8	9	8	9	8	9	10	9	10	11	10	11	12	11	12	13	12
// 9	8	9	8	9	8	9	8	9	8	9	10	9	10	11	10	11	12	11	12	13
// 8	7	8	7	8	7	8	7	8	9	8	9	10	9	10	11	10	11	12	11	12
// 7	8	7	8	7	8	7	8	7	8	9	8	9	10	9	10	11	10	11	12	11
// 6	7	6	7	6	7	6	7	8	7	8	9	8	9	10	9	10	11	10	11	12
// 7	6	7	6	7	6	7	6	7	8	7	8	9	8	9	10	9	10	11	10	11
// 6	5	6	5	6	5	6	7	6	7	8	7	8	9	8	9	10	9	10	11	10
// 5	6	5	6	5	6	5	6	7	6	7	8	7	8	9	8	9	10	9	10	11
// 4	5	4	5	4	5	6	5	6	7	6	7	8	7	8	9	8	9	10	11	10
// 5	4	5	4	5	4	5	6	5	6	7	6	7	8	7	8	9	10	9	10	11
// 4	3	4	3	4	5	4	5	6	5	6	7	6	7	8	9	8	9	10	11	10
// 3	4	3	4	3	4	5	4	5	6	5	6	7	8	7	8	9	10	9	10	11
// 2	3	2	3	4	3	4	5	4	5	6	7	6	7	8	9	8	9	10	11	10
// 3	2	3	2	3	4	3	4	5	6	5	6	7	8	7	8	9	10	9	10	11
// 2	1	4	3	2	3	4	5	4	5	6	7	6	7	8	9	8	9	10	11	10
// 3	2	1	2	3	4	3	4	5	6	5	6	7	8	7	8	9	10	9	10	11
// 0	3	2	3	2	3	4	5	4	5	6	7	6	7	8	9	8	9	10	11	10

// class Solution {
//     int[][] cost = new int[305][305];
//     int dfs(int x, int y) {
//         if (x == 0 && y == 0) {
//             return 0;
//         }
//         if (x < 0 || y < 0) {
//             return dfs(Math.abs(x), Math.abs(y));
//         }
//         if (cost[x][y] != 0) {
//             return cost[x][y];
//         }
//         if (x + y == 2) {
//             return cost[x][y] = 2;
//         }
//         cost[x][y] = Math.min(dfs(x - 2, y - 1), dfs(x - 1, y - 2)) + 1;
//         return cost[x][y];
//     }
//     public int minKnightMoves(int x, int y) {
//         return dfs(Math.abs(x), Math.abs(y));
//     }
// }
// [Editorial]
//  Lemma: "[0, 0] -> [x, y] where |x| + |y| = 2 need 2 steps."
//  And the optimal stragey is always move 'towards' the end point. 

// [Analysis]
//  Thm: "The knight can reach any node on the board"
//  Prove: [0, 0] -> [1, 2] -> [2, 0] -> [0, 1]
//         [0, 0] -> [2, -1] -> [1, 1],
//         By symmetry, [0,0] can visit all nodes inside [+-1, +-1],
//         so all node can be visited. 
//  Lemma: "So when we need to visit [x, y], 
//          the shortest path will visit at max [max(x + 1, 2), max(y + 1, 2)]"
//  Prove： can discuss the situations that prev = [x - 1, y`] or [x - 2, y`]

// [Editorial][TODO]
//  Bidirectional BFS. 
//  Maintain two queues, start from [0, 0] and [x, y]
//  And a map for each queue to store the distance of points in each queue. 
//  When found a point in a queue is also in another queue, return the sum of distance. 

// class Solution {
//     static final int[] DIR = new int[] {
//         1, 2, 1, -2, -1, 2, -1, -2, 1,
//     };
//     public int minKnightMoves(int x, int y) {
//         if (x == 0 && y == 0) {
//             return 0;
//         }
//         x = Math.abs(x);
//         y = Math.abs(y);
//         Queue<int[]> q = new LinkedList<>();
//         // Set<List<Integer>> visited = new HashSet<>();
//         boolean[][] visited = new boolean[320][320];
//         q.offer(new int[] {0, 0});
//         visited[10][10] = true;
//         int ans = 0;
//         while (true) {
//             int size = q.size();
//             ans++;
//             while (size > 0) {
//                 size--;
//                 int[] curr = q.poll();
//                 // [Failed]
//                 //  Check in here is not good, 
//                 //  may have dulplicate nodes enqueue on same `level`. 
//                 //  Still need check visited[curr], but still cost space in queue. 
//                 // visited.add(List.of(curr[0], curr[1]));
//                 // visited[curr[0] + 305][curr[1] + 305] = true;
//                 for (int i = 0; i < 8; i++) {
//                     if (curr[0] + DIR[i] == x && curr[1] + DIR[i + 1] == y) {
//                         return ans;
//                     }
//                     int[] next = new int[] {curr[0] + DIR[i], curr[1] + DIR[i + 1]};
//                     // if (visited.contains(List.of(next[0], next[1]))) {
//                     if (next[0] < -10 || next[1] < -10 || 
//                         next[0] > 310 || next[1] > 310 || 
//                         visited[next[0] + 10][next[1] + 10]) {
//                         continue;
//                     }
//                     visited[next[0] + 10][next[1] + 10] = true;
//                     q.offer(next);
//                 }
//             }
//         }
//         // return -1;
//     }
// }
// [Editorial]
//  Use boolean[][] to reduce space, and optimize enqueue. 
//  visit[][] size can be determined from the [Analysis]. 
// [Ming][Failed]
//  The enqueue and dequeue process need to be optimized. 
