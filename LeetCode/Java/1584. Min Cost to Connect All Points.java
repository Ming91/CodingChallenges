// Daily Question 09/15/2023
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] inMST = new boolean[n];
        int added = 0;
        int ans = 0;
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        while (added < n) {
            int currDist = Integer.MAX_VALUE;
            int curr = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && minDist[i] < currDist) {
                    currDist = minDist[i];
                    curr = i;
                }
            }
            ans += currDist;
            inMST[curr] = true;
            added++;
            for (int i = 0; i < n; i++) {
                if (!inMST[i]) {
                    int dist = Math.abs(points[i][0] - points[curr][0])
                            + Math.abs(points[i][1] - points[curr][1]);
                    minDist[i] = Math.min(minDist[i], dist);
                }
            }
        }
        return ans;
    }
}
// [Beat 99%] Since each time update one point, maintain a array of points.
//  Keep unadded points together(on the right part of the array). 
//  Each time find next point, swap it with the leftmost one of unadded points.

// [Editorial] Prim using minDist[], update remain distance after each point added

// [Ming] Kruskal using Sort and UnionFind
// class Solution {
//     int n;
//     int m;

//     class UnionFind {
//         int[] parent;
//         UnionFind(int n) {
//             parent = new int[n];
//             for (int i = 0; i < n; i++) {
//                 parent[i] = i;
//             }
//         }

//         int find(int x) {
//             if (parent[x] != x) {
//                 parent[x] = find(parent[x]);
//             }
//             return parent[x];
//         }

//         boolean union(int x, int y) {
//             int fx = find(x);
//             int fy = find(y);
//             if (fx == fy) {
//                 return false;
//             }
//             parent[fx] = fy;
//             return true;
//         }
//     }

//     int getDistance(int[] pi, int[] pj) {
//         int dist = 0;
//         dist += Math.abs(pi[0] - pj[0]);
//         dist += Math.abs(pi[1] - pj[1]);
//         return dist;
//     }

//     int kruskal(UnionFind uf, int[][] edges) {
//         int ans = 0;
//         int count = 0;
//         for (int[] e : edges) {
//             int i = e[1];
//             int j = e[2];
//             if (uf.union(i, j)) {
//                 count++;
//                 ans += e[0];
//                 if (count == n - 1) {
//                     return ans;
//                 }
//             }
//         }
//         return ans;
//     }

//     public int minCostConnectPoints(int[][] points) {
//         n = points.length;
//         m = n * (n + 1) / 2;
//         int idx = 0;
//         int[][] edges = new int[m][3];
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 edges[idx][0] = getDistance(points[i], points[j]);
//                 edges[idx][1] = i;
//                 edges[idx][2] = j;
//                 idx++;
//             }
//         }
//         Arrays.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
//         UnionFind uf = new UnionFind(n);
//         return kruskal(uf, edges);
//     }
// }
