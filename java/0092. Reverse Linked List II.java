// Daily Problem 09/07/2023
// Top Interview 150 LinkedList Q5
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
// Top Interview 150 09/20/2023 Impl
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        int idx = 1;
        while (idx < left) {
            prev = curr;
            curr = curr.next;
            idx++;
        }
        ListNode leftEnd = prev;
        ListNode tail = curr;
        while (idx <= right) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            idx++;
        }
        if (tail != null) {
            tail.next = curr;
        }
        if (leftEnd != null) {
            leftEnd.next = prev;
            return head;
        } else {
            return prev;
        }
    }
}
// Daily Problem 09/07/2023 Impl
// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if (left == right) {
//             return head;
//         }
//         ListNode curr = head;
//         ListNode prev = null;
//         int count = 0;
//         while (count < left - 1) {
//             prev = curr;
//             curr = curr.next;
//             count++;
//         }
//         ListNode leftPrev = prev;
//         ListNode end = curr;
//         while (count < right) {
//             ListNode temp = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = temp;
//             count++;
//         }
//         end.next = curr;
//         if (left == 1) {
//             return prev;
//         } else {
//             leftPrev.next = prev;
//             return head;
//         }
//     }
// }
