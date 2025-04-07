// LeetCode 75 Linked List Q4
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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;

            slow = slowNext;
        }
        int max = 0;
        while (slow != null) {
            max = Math.max(max, slow.val + prev.val);
            slow = slow.next;
            prev = prev.next;
        }
        return max;
    }
}
// idea: reverse while finding mid ptr
