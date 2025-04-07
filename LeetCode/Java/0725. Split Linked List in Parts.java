// Daily Problem 09/06/2023
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if (head == null) {
            return ans;
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        int idx = 0;
        curr = head;
        // if (count <= k) {
        //     while (curr != null) {
        //         ans[idx++] = curr;
        //         ListNode temp = curr.next;
        //         curr.next = null;
        //         curr = temp;
        //     }
        //     return ans;
        // }
        
        // if count <= k, size = count / k = 0, remain > 0
        // we have ans[idx++] = curr, means alread has 1.
        int size = count / k - 1;
        int remain = count % k;
        while (curr != null) {
            ans[idx++] = curr;
            int step = 0;
            while (curr != null && step < size) {
                curr = curr.next;
                step++;
            }
            // size = -1, remain > 0, means each element in the array has one node
            // if not use count / k - 1 ans check size, we will have two nodes here
            if (size >= 0 && remain > 0) {
                curr = curr.next;
                remain--;
            }
            if (curr == null) {
                break;
            }
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }
        return ans;
    }
}
