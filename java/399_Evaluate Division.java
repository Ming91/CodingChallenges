// LeetCode 75 Graphs - DFS Q4
class Solution {
    class UnionFind {
        int[] fathers;
        // int[] rank;
        double[] values;
        UnionFind(int n) {
            fathers = new int[n];
            // rank = new int[n];
            values = new double[n];
            for (int i = 0; i < n; i++) {
                fathers[i] = i;
                values[i] = 1.0;
            }
        }

        Pair<Integer, Double> find(int x) {
            if (fathers[x] == x) {
                return new Pair<>(x, values[x]);
            }
            Pair<Integer, Double> p = find(fathers[x]);
            fathers[x] = p.getKey();
            values[x] = p.getValue() * values[x];
            return new Pair<>(fathers[x], values[x]);
        }

        void union(int x, int y, double v) {
            Pair<Integer, Double> px = find(x), py = find(y);
            int fx = px.getKey(), fy = py.getKey();
            double vx = px.getValue(), vy = py.getValue();
            if (fx == fy) {
                return ;
            }
            fathers[fx] = fy;
            values[fx] = values[y] / values[x] * v;
            return ;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> strToIdx = new HashMap<>();
        int n = values.length;
        int len = 0;
        // Step 1. Transfer to Double[][] map
        //  1.1 map string to idx
        for (int i = 0; i < n; i++) {
            List<String> Pair = equations.get(i);
            String l = Pair.get(0);
            String r = Pair.get(1);
            if (!strToIdx.containsKey(l)) {
                strToIdx.put(l, len++);
            }
            if (!strToIdx.containsKey(r)) {
                strToIdx.put(r, len++);
            }
        }
        // 1.2 map equations to adj matrix
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < n; i++) {
            List<String> Pair = equations.get(i);
            String l = Pair.get(0);
            String r = Pair.get(1);
            int idxL = strToIdx.get(l);
            int idxR = strToIdx.get(r);
            uf.union(idxL, idxR, values[i]);
        }

        int idx = 0;
        double[] ans = new double[queries.size()];
        boolean[] visited = new boolean[len];
        for (List<String> query : queries) {
            String l = query.get(0);
            String r = query.get(1);
            int idxL = strToIdx.getOrDefault(l, -1);
            int idxR = strToIdx.getOrDefault(r, -1);
            if ((idxL | idxR) < 0) {
                ans[idx++] = -1.0;
                continue;
            }
            // for (int i = 0; i < len; i++) {
            //     for (int j = 0; j < len; j++) {
            //         System.out.printf("%.4f,", adj[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println("---------------");
            Pair<Integer, Double> pl = uf.find(idxL), pr = uf.find(idxR);
            if (pl.getKey() != pr.getKey()) {
                ans[idx++] = -1.0;
            } else {
                ans[idx++] = pl.getValue() / pr.getValue();
            }
        }
        return ans;        
    }
}

// 人家用的并查集, O(m*log(n))
// 并查集方法a/b = v, 则a->b, a.v = v
// 查找的时候, 则 a.father = a.father..father, a.v = a.father..v * a.v
// 例如a/b, b/c, 如果以后找a了, 则a直接挂c上
// 读入的时候, 对于每个式子x/y是连接find(x)和find(y)
// 这题查询的时候是constant, 只看find(x)和find(y)的结果是不是一样就行
// 有点啰嗦了, 还是对并查集不熟练

// 用m*n的找路方法,
//  用string映射到idx, 存在double[][]里面, 
//  可以先映射, 确定double的大小
//  然后从curr到target找路, 边找边更新
// class Solution {
//     static final double EPS = 1e-10;
//     Double[][] adj;
//     int len;
//     Double dfs(int curr, int target, boolean[] visited) {
//         if (adj[curr][target] != null) {
//             return adj[curr][target];
//         }
//         visited[curr] = true;
//         for (int i = 0; i < len; i++) {
//             if (i == target || visited[i]) {
//                 continue;
//             }
//             Double res1 = adj[curr][i];
//             if (res1 != null && !Double.isNaN(res1)) {
//                 Double res2 = dfs(i, target, visited);
//                 if (res2 != null && !Double.isNaN(res2)) {
//                     adj[curr][target] = res1 + res2;
//                     adj[target][curr] = -adj[curr][target];
//                     visited[curr] = false;
//                     return adj[curr][target];
//                 }
//             }
//         }
//         visited[curr] = false;
//         // Code below is wrong, no path now but can have path later
//         adj[curr][target] = Double.NaN;
//         adj[target][curr] = Double.NaN;
//         return null;
//     }
//     public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//         Map<String, Integer> strToIdx = new HashMap<>();
//         int n = values.length;
//         len = 0;
//         // Step 1. Transfer to Double[][] map
//         //  1.1 map string to idx
//         for (int i = 0; i < n; i++) {
//             List<String> Pair = equations.get(i);
//             String l = Pair.get(0);
//             String r = Pair.get(1);
//             if (!strToIdx.containsKey(l)) {
//                 strToIdx.put(l, len++);
//             }
//             if (!strToIdx.containsKey(r)) {
//                 strToIdx.put(r, len++);
//             }
//         }
//         // 1.2 map equations to adj matrix
//         adj = new Double[len][len];
//         for (int i = 0; i < n; i++) {
//             List<String> Pair = equations.get(i);
//             String l = Pair.get(0);
//             String r = Pair.get(1);
//             int idxL = strToIdx.get(l);
//             int idxR = strToIdx.get(r);
//             adj[idxL][idxL] = 0.0;
//             adj[idxR][idxR] = 0.0;
//             adj[idxL][idxR] = Math.log(values[i]);
//             adj[idxR][idxL] = -adj[idxL][idxR];
//         }
//         int idx = 0;
//         double[] ans = new double[queries.size()];
//         boolean[] visited = new boolean[len];
//         for (List<String> query : queries) {
//             String l = query.get(0);
//             String r = query.get(1);
//             int idxL = strToIdx.getOrDefault(l, -1);
//             int idxR = strToIdx.getOrDefault(r, -1);
//             if ((idxL | idxR) < 0) {
//                 ans[idx++] = -1.0;
//                 continue;
//             }
//             // for (int i = 0; i < len; i++) {
//             //     for (int j = 0; j < len; j++) {
//             //         System.out.printf("%.4f,", adj[i][j]);
//             //     }
//             //     System.out.println();
//             // }
//             // System.out.println("---------------");
//             Double res = dfs(idxL, idxR, visited);
//             if (res == null || Double.isNaN(res)) {
//                 ans[idx++] = -1.0;
//             } else {
//                 ans[idx++] = Math.exp(res);
//             }
//         }
//         return ans;
//     }
// }
