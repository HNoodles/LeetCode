/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* result = new ListNode(0);
        ListNode* head = result;

        int sum = 0;

        while (l1 || l2) {
            sum = result->val + (l1 ? l1->val : 0) + (l2 ? l2->val : 0);

            result->val = sum % 10;

            if (((l1 && l1->next) || (l2 && l2->next)) || (sum / 10))
                result->next = new ListNode(sum / 10);
                result = result->next;

            l1 = l1 ? l1->next : NULL;
            l2 = l2 ? l2->next : NULL;
        }

        return head;
    }
};