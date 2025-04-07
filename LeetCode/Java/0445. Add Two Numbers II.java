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
    Stack<Integer> listToStack(ListNode l) {
        Stack<Integer> s = new Stack<>();
        while (l != null) {
            s.push(l.val);
            l = l.next;
        }
        return s;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) 
        {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        Stack<Integer> s1 = listToStack(l1);
        Stack<Integer> s2 = listToStack(l2);
        ListNode ans = new ListNode();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry == 1) {
            int s = carry;
            s += s1.isEmpty() ? 0 : s1.pop();
            s += s2.isEmpty() ? 0 : s2.pop();
            ans.val = s % 10;
            carry = s / 10;
            ListNode head = new ListNode();
            head.next = ans;
            ans = head;
        }
        return ans.next;
    }
}
// can use stack without reverse, but result in slower runtime

// naive reverse list
// class Solution {
//     ListNode reverse(ListNode l) {
//         ListNode current = l;
//         ListNode prev = null;
//         ListNode nxt = null;
//         while (current != null) {
//             nxt = current.next;
//             current.next = prev;
//             prev = current;
//             current = nxt;
//         }
//         return prev;
//     }
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         if (l1.val == 0) 
//         {
//             return l2;
//         }
//         if (l2.val == 0) {
//             return l1;
//         }
        
//         ListNode r1 = reverse(l1);
//         ListNode r2 = reverse(l2);
//         ListNode ansRev = new ListNode(0);
//         ListNode ansRevRoot = ansRev;
//         while (true) {
//             //boolean isRemain = false;
//             int s = ansRev.val;
//             if (r1 != null) {
//                 s += r1.val;
//                 r1 = r1.next;
//             }
//             if (r2 != null) {
//                 s += r2.val;
//                 r2 = r2.next;
//             }
//             ansRev.val = s % 10;
//             if (r1 != null || r2 != null || s >= 10) {
//                 ansRev.next = new ListNode(s / 10);
//                 ansRev = ansRev.next;
//             } else {
//                 break;
//             }
//         }
//         ListNode ans = reverse(ansRevRoot);
//         return ans;
//     }
// }
