// Daily Challenge 08/15/2023
// Top Interview 150 Linked List Q10
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode less = new ListNode(-101);
        ListNode more = new ListNode(-101);
        ListNode lessHead = less;
        ListNode moreHead = more;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = head;
            } else {
                more.next = head;
                more = head;
            }
            head = head.next;
        }
        // if (less == lessHead) {
        //     return moreHead.next;
        // }
        // if (more == moreHead) {
        //     return lessHead.next;
        // }

        // if not assign null, there will be cycle
        // [2, 4, 2], 3 -> more [4, 2]
        more.next = null;
        less.next = moreHead.next;
        return lessHead.next;
    }
}
// Linked List exp++
