// Daily Question 09/14/2023
class Solution {
    void dfs(Map<String, Queue<String>> adjLists,
            List<String> ans, String curr) {
        Queue<String> neighbors = adjLists.get(curr);
        if (neighbors == null) {
            ans.add(curr);
            return;
        }
        while (!neighbors.isEmpty()) {
            String neighbor = neighbors.poll();
            dfs(adjLists, ans, neighbor);
        }
        ans.add(curr);
        return;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjLists = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!adjLists.containsKey(from)) {
                adjLists.put(from, new PriorityQueue<>());
            }
            adjLists.get(from).add(to);
        }
        List<String> ans = new ArrayList<>();
        dfs(adjLists, ans, "JFK");
        Collections.reverse(ans);
        return ans;
    }
}
// [Editorial]
// It's a Euler Path problem.
// Use simpler version of Hierholzer's Algorithm. (Actually the idea of Hierholzer Algo)
// Since it is guaranteed to have a solution, if dfs visit a vertex that has no unvisited edge,
// it's the endpoint of current path. Add it to list. 
// Reverse the list to get real answer.

// 算法思想: 走投无路就入栈, 最后的答案就是依次出栈的结果.

// Using priority queue or sorted adjacent list to make sure visit smaller lexical neighbor first.

// [Ming] naive search
// class Solution {
//     int n;
//     boolean found;
//     void dfs(List<Integer>[] adjLists, 
//              List<Integer> ans, int[][] count, int curr) {
//         if (ans.size() == n + 1) {
//             found = true;
//             return ;
//         }
//         List<Integer> neighbors = adjLists[curr];
//         if (neighbors == null) {
//             return ;
//         }
//         for (Integer neighbor : neighbors) {
//             if (count[curr][neighbor] > 0) {
//                 count[curr][neighbor]--;
//                 ans.add(neighbor);
//                 dfs(adjLists, ans, count, neighbor);
//                 if (found) {
//                     return ;
//                 }
//                 ans.remove(ans.size() - 1);
//                 count[curr][neighbor]++;
//             }
//         }
//         return ;
//     }
//     public List<String> findItinerary(List<List<String>> tickets) {
//         n = tickets.size();
//         Set<String> added = new HashSet<>();
//         for (List<String> ticket : tickets) {
//             String from = ticket.get(0);
//             String to = ticket.get(1);
//             added.add(from);
//             added.add(to);
//         }
//         List<String> addedList = new ArrayList<>(added);
//         Collections.sort(addedList);
//         int m = addedList.size();
//         Map<String, Integer> strToIdx = new HashMap<>();
//         String[] idxToStr = new String[m];
//         int idx = 0;
//         int jfk = 0;
//         for (String str : addedList) {
//             if (str.equals("JFK")) {
//                 jfk = idx;
//             }
//             idxToStr[idx] = str;
//             strToIdx.put(str, idx++);
//         }
//         List<Integer>[] adjLists = new ArrayList[m];
//         int[][] count = new int[m][m];
//         for (List<String> ticket : tickets) {
//             String from = ticket.get(0);
//             String to = ticket.get(1);
//             int f = strToIdx.get(from);
//             int t = strToIdx.get(to);
//             if (adjLists[f] == null) {
//                 adjLists[f] = new ArrayList<Integer>();
//             }
//             adjLists[f].add(t);
//             count[f][t]++;
//         }
//         for (List<Integer> adjList : adjLists) {
//             if (adjList == null) {
//                 continue;
//             }
//             Collections.sort(adjList);
//         }
//         List<Integer> intAns = new ArrayList<>();
//         found = false;
//         intAns.add(jfk);
//         dfs(adjLists, intAns, count, jfk);
//         System.out.println(intAns);
//         List<String> ans = new ArrayList<>();
//         for (int a : intAns) {
//             ans.add(idxToStr[a]);
//         }
//         return ans;
//     }
// }
