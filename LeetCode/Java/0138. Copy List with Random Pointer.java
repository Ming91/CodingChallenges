// Top Interview 150 Linked List Q4
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
// Top Interview 150 09/20/2023 Impl
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            Node cloned = new Node(curr.val);
            cloned.next = curr.next;
            curr.next = cloned;
            curr = cloned.next;
        }
        curr = head;
        Node clonedHead = head.next;
        while (curr != null) {
            Node cloned = curr.next;
            cloned.random = curr.random == null ? null : curr.random.next;
            curr = cloned.next;
        }
        curr = head;
        while (curr != null) {
            Node cloned = curr.next;
            curr.next = cloned.next;
            cloned.next = curr.next == null ? null : curr.next.next;
            curr = curr.next;
        }
        return clonedHead;
    }
}
// You have to use the third loop, since we need curr.random.next,
// If we unlinke curr and cloned here, the curr.random.next could link to the original list.

// Daily Problem 09/05/2023 Impl
// class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null) {
//             return null;
//         }
//         Node ptr = head;
//         while (ptr != null) {
//             Node cloned = new Node(ptr.val);
//             cloned.next = ptr.next;
//             ptr.next = cloned;
//             ptr = cloned.next;
//         }
//         ptr = head;
//         while (ptr != null) {
//             Node cloned = ptr.next;
//             cloned.random = ptr.random == null ? null : ptr.random.next;
//             ptr = ptr.next.next;
//         }
//         ptr = head;
//         Node ans = head.next;
//         while (ptr != null) {
//             Node cloned = ptr.next;
//             ptr.next = cloned.next;
//             cloned.next = cloned.next == null ? null : cloned.next.next;
//             ptr = ptr.next;
//         }
//         return ans;
//     }
// }
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
