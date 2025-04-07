// Top Interview 150 Binary Tree General Q7
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node leftmost = root;
        while (leftmost != null) {
            Node curr = leftmost;
            Node prev = null;
            leftmost = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (prev == null) {
                        leftmost = curr.left;
                        prev = curr.left;
                    } else {
                        prev.next = curr.left;
                        prev = prev.next;
                    }
                }
                if (curr.right != null) {
                    if (prev == null) {
                        leftmost = curr.right;
                        prev = curr.right;
                    } else {
                        prev.next = curr.right;
                        prev = prev.next;
                    }
                }
                curr = curr.next;
            }
        }
        return root;
    }
}
// [Editorial] see .next in a view of linked list.
//  Process it level by level with a start point of leftmost node.

// [Editorial] Level Order Traversal
//  Should think of this approach. 
// class Solution {
//     public Node connect(Node root) {
//         if (root == null) {
//             return null;
//         }
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             q.add(null);
//             while (q.peek() != null) {
//                 Node curr = q.poll();
//                 curr.next = q.peek();
//                 if (curr.left != null) {
//                     q.add(curr.left);
//                 }
//                 if (curr.right != null) {
//                     q.add(curr.right);
//                 }
//             }
//             q.poll();
//         }
//         return root;
//     }
// }
