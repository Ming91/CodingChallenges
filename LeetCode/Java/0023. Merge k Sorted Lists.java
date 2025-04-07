// Top Interview 150 Divide & Conquer Q4
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
    ListNode mergerTwoLists(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if (a != null) {
            curr.next = a;
        } else {
            curr.next = b;
        }
        return dummyHead.next;
    }
    ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        ListNode left = mergeLists(lists, start, (start + end) / 2);
        ListNode right = mergeLists(lists, (start + end) / 2 + 1, end);
        return mergerTwoLists(left, right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }
}
// [Editorial]
//  Merge pairs from size == 1 to n/2, so each node at most be visited with log(n) times.

// [Ming] Merge one by one, but worsest case will visit one node at most N(N=kn) times.
// class Solution {
//     ListNode mergerTwoLists(ListNode a, ListNode b) {
//         ListNode dummyHead = new ListNode();
//         ListNode curr = dummyHead;
//         while (a != null && b != null) {
//             if (a.val <= b.val) {
//                 curr.next = a;
//                 a = a.next;
//             } else {
//                 curr.next = b;
//                 b = b.next;
//             }
//             curr = curr.next;
//         }
//         if (a != null) {
//             curr.next = a;
//         } else {
//             curr.next = b;
//         }
//         return dummyHead.next;
//     }
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null) {
//             return null;
//         }
//         ListNode ans = null;
//         for (ListNode list : lists) {
//             ans = mergerTwoLists(ans, list);
//         }
//         return ans;
//     }
// }
