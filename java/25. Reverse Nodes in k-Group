// Top Interview 150 LinkedList Q6
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode prev = reverseKGroup(curr, k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count--;
        }
        return prev;
    }
}
// [Beat 99% / Editorial]
//  Use recursion, cost (n / k) space since each head wouldn't return till the end.
//  But has better structure and faster.

// [Ming] O(1) space iteration impl
// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (k == 1) {
//             return head;
//         }
//         ListNode prev = null;
//         ListNode curr = head;
//         ListNode ans = null;
//         while (true) {
//             int count = 0;
//             ListNode probe = curr;
//             while (count < k && probe != null) {
//                 probe = probe.next;
//                 count++;
//             }
//             if (count != k) {
//                 break;
//             }
//             count = 0;

//             // Reverse the linked list
//             ListNode leftEnd = prev;
//             ListNode tail = curr;
//             while (count < k) {
//                 ListNode next = curr.next;
//                 curr.next = prev;
//                 prev = curr;
//                 curr = next;
//                 count++;
//             }
//             if (ans == null) {
//                 ans = prev;
//             } else {
//                 leftEnd.next = prev;
//             }
//             tail.next = curr;
//             prev = tail;
//         }
//         return ans;
//     }
// }
