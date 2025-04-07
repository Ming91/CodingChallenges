// Daily Challenge 08/20/2023
class Solution {
    int len;
    void dfs(int[] ans, List<Integer>[] graph, int[] degree, int i) {
        if (i < ans.length) {
            ans[len++] = i;
        }
        // make it -1 as marked visited
        degree[i]--;
        for (int succ : graph[i]) {
            degree[succ]--;
            if (degree[succ] == 0) {
                dfs(ans, graph, degree, succ);
            }
        }
        return ;
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // make group as a extra item that connect to its items
        List<Integer>[] graph = new ArrayList[m + n];
        int[] degree = new int[m + n];

        for (int i = 0; i < m + n; i++) {
            graph[i] = new ArrayList<>();
        }

        // connect group node to item node
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                continue;
            }
            graph[n + group[i]].add(i);
            degree[i]++;
        }
        // connect items, (and groups if needed)
        // since group connect to its items before, add groups conncet now can make sure
        // item for curr group first added, then next group
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                int currGroup = group[curr] == -1 ? curr : group[curr] + n;
                int prevGroup = group[prev] == -1 ? prev : group[prev] + n;
                if (currGroup == prevGroup) {
                    graph[prev].add(curr);
                    degree[curr]++;
                } else {
                    graph[prevGroup].add(currGroup);
                    degree[currGroup]++;
                }
            }
        }

        int[] ans = new int[n];
        len = 0;
        // use recursive rather than stack or queue
        for (int i = 0; i < m + n; i++) {
            if (degree[i] == 0) {
                dfs(ans, graph, degree, i);
            }
        }
        return len == n ? ans : new int[0];
    }
}

// use topological sort for item and group, 
// for the sorted item, add item to their group
// for the sorted group, add item in each group to ans

// queue a little slower than stack
// class Solution {
//     int[] topologicalSort(List<Integer>[] graph, int[] degree) {
//         int[] ans = new int[degree.length];
//         int len = 0;
//         Stack<Integer> stack = new Stack<>();
//         // Queue<Integer> stack = new LinkedList<>();
//         for (int i = 0; i < degree.length; i++) {
//             if (degree[i] == 0) {
//                 stack.add(i);
//             }
//         }
//         while (!stack.isEmpty()) {
//             Integer curr = stack.pop();
//             ans[len++] = curr;
//             if (graph[curr] == null) {
//                 continue;
//             }
//             for (Integer prev : graph[curr]) {
//                 degree[prev]--;
//                 if (degree[prev] == 0) {
//                     stack.add(prev);
//                 }
//             }
//         }
//         return len == degree.length ? ans : new int[0];
//     }
//     public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
//         int gId = m;
//         for (int i = 0; i < n; i++) {
//             group[i] = group[i] == -1 ? gId++ : group[i];
//         }
//         List<Integer>[] itemGraph = new ArrayList[n];
//         List<Integer>[] groupGraph = new ArrayList[gId];
//         int[] itemDegree = new int[n];
//         int[] groupDegree = new int[gId];
//         for (int i = 0; i < n; i++) {
//             for (Integer prev : beforeItems.get(i)) {
//                 itemDegree[i]++;
//                 if (itemGraph[prev] == null) {
//                     itemGraph[prev] = new ArrayList<>();
//                 }
//                 itemGraph[prev].add(i);
//                 if (group[i] != group[prev]) {
//                     if (groupGraph[group[prev]] == null) {
//                         groupGraph[group[prev]] = new ArrayList<>();
//                     }
//                     groupGraph[group[prev]].add(group[i]);
//                     groupDegree[group[i]]++;
//                 }
//             }
//         }

//         int[] itemOrder = topologicalSort(itemGraph, itemDegree);
//         int[] groupOrder = topologicalSort(groupGraph, groupDegree);

//         if (itemOrder.length == 0 || groupOrder.length == 0) {
//             return new int[0];
//         }

//         // [group1, group2, ...] -> [(item1, item2, ...), (item1, item2, ...) ...]
//         List<Integer>[] orderedGroups = new ArrayList[gId];
//         for (int item : itemOrder) {
//             if (orderedGroups[group[item]] == null) {
//                 orderedGroups[group[item]] = new ArrayList<>();
//             }
//             orderedGroups[group[item]].add(item);
//         }

//         int[] ans = new int[n];
//         int len = 0;
//         for (int groupId : groupOrder) {
//             if (orderedGroups[groupId] == null) {
//                 continue;
//             }
//             for (int item : orderedGroups[groupId]) {
//                 ans[len++] = item;
//             }
//         }
//         return ans;
//     }
// }
