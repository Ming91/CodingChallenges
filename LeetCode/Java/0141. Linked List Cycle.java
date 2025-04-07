// Top Interview 150 Linked List Q1
// Daily Problem 09/04/2023
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> visited = new HashSet<>();
//         ListNode curr = head;
//         while (curr != null) {
//             if (visited.contains(curr)) {
//                 return true;
//             }
//             visited.add(curr);
//             curr = curr.next;
//         }
//         return false;
//     }
// }
