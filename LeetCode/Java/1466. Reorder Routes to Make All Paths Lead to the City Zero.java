// LeetCode 75 Graphs - DFS Q3
// class Solution {
//     public int minReorder(int n, int[][] arr) {
//         boolean[] visited = new boolean[n];
//         visited[0] = true;
//         LinkedList<int[]> q = new LinkedList<>();
//         int count = 0;
//         // Arrays.sort(arr, (a, b) -> {
//         //     return Math.min(a[0], a[1]) - Math.min(b[0], b[1]);
//         // });
//         Random rand = new Random();
//         for (int i = 0; i < n; i++) {
//             int l = rand.nextInt(n - 1);
//             int r = rand.nextInt(n - 1);
//             int[] temp = arr[l];
//             arr[l] = arr[r];
//             arr[r] = temp;
//         }
//         for (int[] a : arr) {
//             // System.out.println(Arrays.toString(c));
//             if (visited[a[0]]) {
//                 ++count;
//                 visited[a[1]] = true;
//             } else {
                
//                 if (visited[a[1]]) {
//                     visited[a[0]] = true;
//                 } else {
//                     q.add(a);
//                 }
//             }
//         }
//         while (!q.isEmpty()) {
//             int[] a = q.pollLast();
//             if (visited[a[0]]) {
//                 ++count;
//                 visited[a[1]] = true;
//             } else {
                
//                 if (visited[a[1]]) {
//                     visited[a[0]] = true;
//                 } else {
//                     q.addFirst(a);
//                 }
//             }
//         }
//         return count;
//     }
// }
// 上面是根据best solution写的答案, 
// 结论是奇技淫巧, 可能是针对一条线的情况, 它反向处理queue会快
//  但实际速度应该是n^2

// 学到的东西: add和addlast区别是前者返回true. 
//            add和offer区别是前者会看容量, 但是linkedlist没有这点, 无区别


// use List[] replace arr

class Solution {
    int ans;
    boolean[] visited;
    void dfs(List<Integer>[] edges, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int neighbor : edges[curr]) {
            int sign = neighbor < 0 ? 1 : 0;
            neighbor = (1 - (sign << 1)) * neighbor;
            if (!visited[neighbor]) {
                ans += sign;
                dfs(edges, visited, neighbor);
            }
        }
        return;
    }
    public int minReorder(int n, int[][] connections) {
        ans = 0;
        visited = new boolean[n];
        List<Integer>[] edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            edges[from].add(-to);
            edges[to].add(from);
        }
        dfs(edges, visited, 0);
        return ans;
    }
}

// use map, if dont convert, will be TLE
// class Solution {
//     int ans;
//     boolean[] visited;
//     void dfs(Map<Integer, List<List<Integer>>> edges, boolean[] visited, int curr) {
//         visited[curr] = true;
//         for (List<Integer> edge : edges.get(curr)) {
//             int neighbor = edge.get(0);
//             int sign = edge.get(1);
//             if (!visited[neighbor]) {
//                 ans += sign;
//                 dfs(edges, visited, neighbor);
//             }
//         }
//         return;
//     }
//     public int minReorder(int n, int[][] connections) {
//         ans = 0;
//         visited = new boolean[n];
//         Map<Integer, List<List<Integer>>> edges = new HashMap<>();
//         for (int[] connection : connections) {
//             edges.computeIfAbsent(connection[0], v -> new ArrayList<>())
//                 .add(List.of(connection[1], 1));
//             edges.computeIfAbsent(connection[1], v -> new ArrayList<>())
//                 .add(List.of(connection[0], 0));
//         }
//         dfs(edges, visited, 0);
//         return ans;
//     }
// }
