// LeetCode 75 Heap / Priority Queue Q4
class Solution {
    public long totalCost(int[] costs, int k, int cand) {
        long ans = 0L;
        int n = costs.length;
        if (cand >= n - cand) {
            Queue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                q.add(costs[i]);
            }
            for (int i = 0; i < k; i++) {
                ans += q.poll();
            }
            return ans;
        }
        int l = 0;
        int r = n - 1;
        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            while (left.size() < cand && l <= r) {
                left.add(costs[l++]);
            }
            while (right.size() < cand && r >= l) {
                right.add(costs[r--]);
            }
            if (right.isEmpty()) {
                ans += left.poll();
                continue;
            }
            if (left.isEmpty() || left.peek() > right.peek()) {
                ans += right.poll();
                continue;
            } 
            ans += left.poll();
        }
        return ans;
    }
}
// two queues, care about if one is empty

// June 2023 impl -- totally no idea
// class Solution {
//     // public class TreeNode() {
//     //     int val;
//     //     int size;
//     //     TreeNode left;
//     //     TreeNode right;
//     //     TreeNode() {};
//     //     TreeNode(int val) {
//     //         this.val = val;
//     //         this.size = 0;
//     //     }
//     //     TreeNode(int val, TreeNode left, TreeNode right) {
//     //         this.val = val;
//     //         this.size = 0;
//     //         this.left = left;
//     //         this.right = right;
//     //     }
//     // }
//     public class Node {
//         int val;
//         int idx;
//         Node() {};
//         Node(int val, int idx) {
//             this.val = val;
//             this.idx = idx;
//         }
//     }
//     public long totalCost(int[] costs, int k, int candidates) {
//         // Comparator<Node> customComp = Comparator
//         //          .comparingInt((Node node) -> node.val)
//         //          .thenComparingInt(node -> node.idx);
//         Comparator<Node> customComp = (Node a, Node b) -> {
//             if (a == null) {
//                 return -1;
//             } 
//             if (b == null) {
//                 return 1;
//             }
//             if (a.val != b.val) {
//                 return a.val - b.val;
//             }
//                 return a.idx - b.idx;
//         };  
//         //Comparator<Node> customComp = (Node a, Node b) -> {return b.val - a.val;}
//             //.comparing((Node a, Node b) -> (b.val - a.val));
//             //.thenComparing((Node a, Node b) -> (b.idx - a.idx));
//         Queue<Node> minHeapFirst = new PriorityQueue<> (candidates, customComp);
//         Queue<Node> minHeapLast = new PriorityQueue<> (candidates, customComp);

//         int n = costs.length;
//         long cost = 0L;
//         int idxFirst = 0;
//         int idxLast = n - 1;
//         for (int i = 0; i < k; i++) {
//             while (idxFirst <= idxLast) {
//                 if (minHeapFirst.size() < candidates) {
//                     minHeapFirst.offer(new Node(costs[idxFirst], idxFirst));
//                     //System.out.println(minHeapFirst.peek().val);
//                     idxFirst++;
//                 }
//                 if (idxFirst > idxLast) {
//                     break;
//                 }
//                 if (minHeapLast.size() < candidates) {
//                     minHeapLast.offer(new Node(costs[idxLast], idxLast));
//                     //System.out.println(minHeapLast.peek().val);
//                     idxLast--;
//                 }
//                 if ( (minHeapFirst.size() == candidates)
//                     && (minHeapLast.size() == candidates)) {
//                     break;
//                 }
//             }
//             if (minHeapLast.peek() == null) {
//                 if (minHeapFirst.peek() != null) {
//                     Node worker = minHeapFirst.poll();
//                     cost += worker.val;
//                     continue;
//                 } else {
//                     return cost;
//                 }
//             }
//             if (minHeapFirst.peek() == null) {
//                 Node worker = minHeapLast.poll();
//                 cost += worker.val;
//                 continue;
//             }
//             if (minHeapFirst.peek().val <= minHeapLast.peek().val) {
//                 Node worker = minHeapFirst.poll();
//                 cost += worker.val;
//             } else {
//                 Node worker = minHeapLast.poll();
//                 cost += worker.val;
//             }
//         }
//         return cost;
//     }
// }
