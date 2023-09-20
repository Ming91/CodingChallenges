// Top Interview 150 LinkedList Q8
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, null);
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null || curr.next.val != curr.val) {
                prev.next = curr;
                prev = curr;

                curr = curr.next;
                
                // end the list, incase [1, 2, 2, 2]
                prev.next = null;
                continue;
            }
            int v = curr.val;
            while (curr != null && curr.val == v) {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
