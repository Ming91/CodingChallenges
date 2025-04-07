// Top Interview 150 Linked List Q7
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy.next;
        ListNode second = dummy;
        int count = 0;
        while (count++ < n) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
// Use one dummy head to reduce delete head detection. 

// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode first = head;
//         ListNode second = head;
//         int i = 0;
//         while (i < n) {
//             first = first.next;
//             i++;
//         }
//         ListNode prev = null;
//         while (first != null) {
//             prev = second;
//             first = first.next;
//             second = second.next;
//         }
//         if (prev == null) {
//             return head.next;
//         } else {
//             prev.next = second.next;
//             return head;
//         }
//     }
// }
// [Editorial] One pass method
//  Two pointers, like Floyd's cycle detect. Head and behind, head just go n steps further.
//  Then go next with same step, when head hit end, delete behind one.

// [Editorial] Basic method
//  One iteration to count. One iter to delete.

// [Ming] Stupid reverse twice method.
// class Solution {
//     ListNode reverse(ListNode head) {
//         ListNode curr = head;
//         ListNode prev = null;
//         while (curr != null) {
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         return prev;
//     }
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode reverseHead = reverse(head);
//         ListNode prev = null;
//         ListNode curr = reverseHead;
//         int count = 1;
//         while (count < n) {
//             prev = curr;
//             curr = curr.next;
//             count++;
//         }
//         if (prev == null) {
//             reverseHead = curr.next;
//         } else {
//             prev.next = curr.next;
//         }
//         return reverse(reverseHead);
//     }
// }
