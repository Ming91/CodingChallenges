// Top Interview 150 Graph General Q3
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    // Node[] map = new Node[101];
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        // if (map[node.val] != null) {
        //     return map[node.val];
        // }
        Node curr = new Node(node.val);
        map.put(curr.val, curr);
        // map[curr.val] = curr;
        for (Node neighbor : node.neighbors) {
            curr.neighbors.add(cloneGraph(neighbor));
        }
        return curr;
    }
}
// [Beat 99%]
//  Runtime of this problem is unstable. But this structure is better than mine. 

// [Ming] Impl, use HashMap before, updated to Node[].
// class Solution {
//     Node[] map;
//     void dfs(Node origin) {
//         if (map[origin.val] != null) {
//             return;
//         }
//         Node cloned = new Node(origin.val);
//         map[cloned.val] = cloned;
//         for (Node neighbor : origin.neighbors) {
//             if (map[neighbor.val] == null) {
//                 dfs(neighbor);
//             }
//             cloned.neighbors.add(map[neighbor.val]);
//         }
//     }
//     public Node cloneGraph(Node node) {
//         if (node == null) {
//             return null;
//         }
//         map = new Node[101];
//         dfs(node);
//         return map[node.val];
//     }
// }
