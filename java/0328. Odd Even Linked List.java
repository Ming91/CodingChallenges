// LeetCode 75 LinkedList Q2
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode eve = head.next;
        ListNode eveStart = eve;
        while (eve != null && eve.next != null) {

            odd.next = eve.next;
            odd = odd.next;
            
            eve.next = odd.next;
            eve = eve.next;
        }
        odd.next = eveStart;
        return head;
    }
}
// better structure

// self impl
// class Solution {
//     public ListNode oddEvenList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode odd = head;
//         ListNode eveStart = head.next;
//         ListNode eve = head.next;
//         while (odd != null) {
//             if (eve == null || eve.next == null) {
//                 odd.next = eveStart;
//                 return head;
//             }
//             odd.next = eve.next;
//             odd = odd.next;
            
//             eve.next = odd.next;
//             eve = eve.next;
//         }
//         return head;
//     }
// }
