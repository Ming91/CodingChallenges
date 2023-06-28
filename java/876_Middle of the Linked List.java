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
    public ListNode middleNode(ListNode head) {
        int l = 0;
        ListNode[] Arr = new ListNode[101];
        while (head != null) {
            l++;
            Arr[l] = head;
            head = head.next;
        }
        return Arr[l / 2 + 1];
    }
}
