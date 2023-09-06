// Daily Problem 09/05/2023
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ptr = head;
        while (ptr != null) {
            Node cloned = new Node(ptr.val);
            cloned.next = ptr.next;
            ptr.next = cloned;
            ptr = cloned.next;
        }
        ptr = head;
        while (ptr != null) {
            Node cloned = ptr.next;
            cloned.random = ptr.random == null ? null : ptr.random.next;
            ptr = ptr.next.next;
        }
        ptr = head;
        Node ans = head.next;
        while (ptr != null) {
            Node cloned = ptr.next;
            ptr.next = cloned.next;
            cloned.next = cloned.next == null ? null : cloned.next.next;
            ptr = ptr.next;
        }
        return ans;
    }
}
// class Solution {
//     Map<Node, Node> oldToNew = new HashMap<>();
//     public Node copyRandomList(Node head) {
//         if (head == null) {
//             return null;
//         }
//         if (oldToNew.containsKey(head)) {
//             return oldToNew.get(head);
//         }
//         Node curr = new Node(head.val);
//         oldToNew.put(head, curr);
//         curr.next = copyRandomList(head.next);
//         curr.random = copyRandomList(head.random);
//         return curr;
//     }
// }
