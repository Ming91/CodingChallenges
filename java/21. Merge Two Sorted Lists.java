// Top Interview 150 Linked List Q3
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode prev = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
// [Editorial] Iteration version, O(1) space

// [Editorial] Recursion O(m + n) space, 
//  since list.next will be assigned until reach the end. 

// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if (list1 == null) {
//             return list2;
//         }
//         if (list2 == null) {
//             return list1;
//         }
//         if (list1.val < list2.val) {
//             list1.next = mergeTwoLists(list1.next, list2);
//             return list1;
//         } else {
//             list2.next = mergeTwoLists(list1, list2.next);
//             return list2;
//         }
//     }
// }

// [Ming] Stupid Impl
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode head = new ListNode();
//         ListNode curr = head;
//         while (list1 != null && list2 != null) {
//             if (list1.val < list2.val) {
//                 curr.next = new ListNode(list1.val);
//                 list1 = list1.next;
//             } else {
//                 curr.next = new ListNode(list2.val);
//                 list2 = list2.next;
//             }
//             curr = curr.next;
//         }
//         if (list1 == null) {
//             curr.next = list2;
//         } else {
//             curr.next = list1;
//         }
//         return head.next;
//     }
// }
