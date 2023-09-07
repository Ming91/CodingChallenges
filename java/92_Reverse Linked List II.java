// Daily Problem 09/07/2023
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        int count = 0;
        while (count < left - 1) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode leftPrev = prev;
        ListNode end = curr;
        while (count < right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        end.next = curr;
        if (left == 1) {
            return prev;
        } else {
            leftPrev.next = prev;
            return head;
        }
    }
}
