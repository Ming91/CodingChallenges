// Top Interview 150 Linked List Q9
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummy;
        int n = 0;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            n++;
        }
        k = k % n;
        prev.next = head;
        curr = head;
        prev = dummy;
        int count = n - k;
        while (count > 0) {
            prev = curr;
            curr = curr.next;
            count--;
        }
        prev.next = null;
        dummy.next = curr;
        return dummy.next;
    }
}
