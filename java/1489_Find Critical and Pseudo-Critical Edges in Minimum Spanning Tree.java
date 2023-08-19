// Daily Challenge 08/20/2023
class Solution {
    int m;
    int n;

    class UnionFind {
        int[] parent;
        int[] size;
        int maxSize;
        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            maxSize = 1;
        }
        @Override
        public UnionFind clone() {
            UnionFind copy = new UnionFind(1);
            copy.parent = Arrays.copyOf(this.parent, n);
            copy.size = Arrays.copyOf(this.size, n);
            copy.maxSize = this.maxSize;
            return copy;
        }
        int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
        boolean union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return false;
            }
            if (size[fy] > size[fx]) {
                int tmp = fy;
                fy = fx;
                fx = tmp;
            }
            parent[fy] = fx;
            size[fx] += size[fy];
            maxSize = Math.max(maxSize, size[fx]);
            return true;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        this.n = n;
        this.m = edges.length;
        int[][] e = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                e[i][j] = edges[i][j];
            }
            e[i][3] = i;
        }
        Arrays.sort(e, (a, b) -> (a[2] - b[2]));

        List<Integer> critical = new ArrayList<>();
        List<Integer> nonCritical = new ArrayList<>();

        List<List<int[]>> buckets = new ArrayList<>();
        List<int[]> newBucket = new ArrayList<>();
        newBucket.add(e[0]);
        for (int i = 1; i < m; i++) {
            if (newBucket.get(0)[2] < e[i][2]) {
                buckets.add(newBucket);
                newBucket = new ArrayList<>();
            }
            newBucket.add(e[i]);
        }
        buckets.add(newBucket);
        UnionFind uf = new UnionFind(n);
        for (List<int[]> currBucket : buckets) {
            if (uf.maxSize == n) {
                break;
            }

            // Kruskal for currEdges in currBucket

            // if two vertices connected, skip this edge

            // use new list can save union loop, 
            // but it's more clear not using loop
            // List<int[]> addedEdges = new ArrayList<>();
            // for (int[] edge : currBucket) {
            //     if (uf.find(edge[0]) != uf.find(edge[1])) {
            //         addedEdges.add(edge);
            //     }
            // }
            int currBucketSize = currBucket.size();
            for (int i = 0; i < currBucketSize; i++) {
                int[] currEdge = currBucket.get(i);
                if (uf.find(currEdge[0]) == uf.find(currEdge[1])) {
                    continue;
                }
                UnionFind currUF = uf.clone();
                for (int j = 0; j < currBucketSize; j++) {
                    if (j == i) {
                        continue;
                    }
                    int[] edge = currBucket.get(j);
                    currUF.union(edge[0], edge[1]);
                }
                if (currUF.find(currEdge[0]) == currUF.find(currEdge[1])) {
                    nonCritical.add(currEdge[3]);
                } else {
                    critical.add(currEdge[3]);
                }
            }
            for (int[] edge : currBucket) {
                uf.union(edge[0], edge[1]);
            }
        }

        return List.of(critical, nonCritical);
    }
}

// beat 99% idea: 
// 1. store edges by weight in a list, if weights are equal, stored in the same bucket
// 2. iterate throught this list
//  2.1 run kruskal on current bucket, without each edge
//  2.2 once finished, if edge two vetices are not connected, 
//      means need curr edge to make the tree. Since smaller edges can't connect two vetices.
//      Add this edge to critical
//  2.3 o/w means can form a mst with same weight edge, add to non critical

// impl the editorial
// use union find two impl kruskal
// for each edge, delete first, if res > mst or node < n, add to critical
// o/w add it first, and check if res == mst, if so add to non critical

// class Solution {
//     int m;
//     int n;

//     class UnionFind {
//         int[] parent;
//         int[] size;
//         int maxSize;
//         UnionFind(int n) {
//             parent = new int[n];
//             size = new int[n];
//             for (int i = 0; i < n; i++) {
//                 parent[i] = i;
//                 size[i] = 1;
//             }
//             maxSize = 1;
//         }
//         int find(int x) {
//             while (parent[x] != x) {
//                 x = parent[x];
//             }
//             return x;
//         }
//         boolean union(int x, int y) {
//             int fx = find(x), fy = find(y);
//             if (fx == fy) {
//                 return false;
//             }
//             if (size[fy] > size[fx]) {
//                 int tmp = fy;
//                 fy = fx;
//                 fx = tmp;
//             }
//             parent[fy] = fx;
//             size[fx] += size[fy];
//             maxSize = Math.max(maxSize, size[fx]);
//             return true;
//         }
//     }
//     public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
//         this.n = n;
//         this.m = edges.length;
//         int[][] e = new int[m][4];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < 3; j++) {
//                 e[i][j] = edges[i][j];
//             }
//             e[i][3] = i;
//         }
//         Arrays.sort(e, (a, b) -> (a[2] - b[2]));

//         UnionFind uf = new UnionFind(n);
//         int mst = 0;
//         for (int[] edge : e) {
//             if (uf.maxSize < n && uf.union(edge[0], edge[1])) {
//                 mst += edge[2];
//             }
//         }
//         // System.out.println(mst);

//         List<Integer> critical = new ArrayList<>();
//         List<Integer> nonCritical = new ArrayList<>();

//         for (int i = 0; i < m; i++) {
//             int[] curr = e[i];
//             UnionFind u = new UnionFind(n);
//             int res = 0;
//             for (int j = 0; j < m; j++) {
//                 if (i != j && u.maxSize < n && u.union(e[j][0], e[j][1])) {
//                     res += e[j][2];
//                 }
//             }
//             if (u.maxSize < n || res > mst) {
//                 critical.add(e[i][3]);
//                 continue;
//             }

//             u = new UnionFind(n);
//             res = e[i][2];
//             u.union(e[i][0], e[i][1]);
//             for (int j = 0; j < m; j++) {
//                 if (i != j && u.maxSize < n && u.union(e[j][0], e[j][1])) {
//                     res += e[j][2];
//                 }
//             }
//             if (res == mst) {
//                 nonCritical.add(e[i][3]);
//             }
//         }

//         return List.of(critical, nonCritical);
//     }
// }

// write own solution according to hints but failed
// 1. kruskal need set to tell if tree connected,
//  eg. example 2, if [1] added 1,2 visited and then [3] added 0,3 visited, my solution will stop
//      with wrong result
