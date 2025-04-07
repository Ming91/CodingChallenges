// Weekly Contest 358 Q2
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
    public ListNode doubleIt(ListNode head) {
        if (head.val == 0) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        int carrier = 0;
        curr = prev;
        prev = null;
        while (curr != null) {
            int s = carrier + (curr.val << 1);
            curr.val = s % 10;
            carrier = s / 10;
            
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        if (carrier > 0) {
            prev = new ListNode(carrier, prev);
        }
        return prev;
    }
}
// reverse linked list two times, calculate the result in the 2nd reverse
