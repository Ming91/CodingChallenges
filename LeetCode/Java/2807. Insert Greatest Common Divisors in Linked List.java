// Biweekly Contest 110 Q2
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
    int gcd(int i, int j) {
        if (i == j) {
            return i;
        }
        if (i < j) {
            return gcd(j - i, i);
        }
        return gcd(i - j, j);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            int val = gcd(curr.val, curr.next.val);
            ListNode g = new ListNode(val, curr.next);
            curr.next = g;
            curr = curr.next.next;
        }
        return head;
    }
}
