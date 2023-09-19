// Top Interview 150 Linked List Q2
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode curr = l1;
        int carrier = 0;
        while (l1 != null && l2 != null) {
            curr = l1;
            l1.val += l2.val + carrier;
            carrier = l1.val / 10;
            l1.val = l1.val % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            curr.next = l2;
            l1 = l2;
        }
        while (l1 != null && carrier > 0) {
            curr = l1;
            l1.val += carrier;
            carrier = l1.val / 10;
            l1.val = l1.val % 10;
            l1 = l1.next;
        }
        if (carrier > 0) {
            curr.next = new ListNode(carrier);
        }
        return head;
    }
}
// [Ming] no extra space! use l1 as ans
