// LeetCode 75 LinkedList Q1
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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        // 不能new新的node出来, 否则[2, 1]情况修改的不是head上的值

        // 先多走一步,这样slow就是要删的前一个
        ListNode fast = head.next.next;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
// class Solution {
//     public ListNode deleteMiddle(ListNode head) {
//         if (head.next == null) {
//             return null;
//         }
//         // 不能new新的node出来, 否则[2, 1]情况修改的不是head上的值
//         ListNode fast = head;
//         ListNode slow = head;
//         ListNode prev = head;
        
//         while (fast != null && fast.next != null) {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         prev.next = slow.next;
//         return head;
//     }
// }
