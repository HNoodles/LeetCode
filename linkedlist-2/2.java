/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode last = result;

        while (l1 != null || l2 != null) {
            result.val += (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

            if (result.val >= 10) {
                result.val -= 10;
                result.next = new ListNode(1);
            } else {
                result.next = new ListNode(0);
            }

            last = result;
            result = result.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (result.val == 0)
            last.next = null;

        return head;
    }
}

// https://leetcode-cn.com/problems/add-two-numbers/