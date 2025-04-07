// LeetCode 75 Linked List Q3
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


// class Solution {
//     public ListNode reverseList(ListNode head) {
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
// }
// better iteration 


// better recursion
// 好好理解一下
//  返回的样子是这样：
//  head -> head.next <- head.next.next
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
// ugly recursion impl
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode ans = reverseList(head.next);
//         ListNode curr = ans;
//         while (curr.next != null) {
//             curr = curr.next;
//         }
//         curr.next = head;
//         head.next = null;
//         return ans;
//     }
// }

// ugly iteration impl
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode ans = null;
//         while (head != null) {
//             ListNode two = head.next;
//             if (two == null) {
//                 head.next = ans;
//                 ans = head;
//                 break;
//             }
//             ListNode third = head.next.next;
//             two.next = head;
//             head.next = ans;
//             ans = two;
//             head = third;
//         }
//         return ans;
//     }
// }
