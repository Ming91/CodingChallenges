/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
 public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry = 0;
        int sum;
        int bl1 = 0, bl2 = 0;
        ListNode* head(0);
        ListNode* res = NULL;
        while (true) {
            sum = 0;
            if (!bl1) {
                sum += l1->val;
                if (!(l1 = l1->next)) bl1 = 1;
            }
            if (!bl2) {
                sum += l2->val;
                if (!(l2 = l2->next)) bl2 = 1;
            }
            sum += carry;
            if (!res) {
                res = new ListNode(sum % 10);
                head = res;
                carry = sum / 10;
            } else {
                res->next = new ListNode(sum % 10);
                res = res->next;
                carry = sum / 10;
            }
            if (bl1 && bl2) {
                if (!carry) break;
                res->next = new ListNode(carry);
                res = res->next;
                break;
            }
        }
        return head;
    }
};
