package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group//">Problem link (LC-25)</a>
 */
public class ReverseNodesInKGroup {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)<br>
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 0; i < k - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return head;
        }
        ListNode nextGroup = temp.next;
        ListNode newHead[] = reverse(head, temp);
        newHead[1].next = reverseKGroup(nextGroup, k);
        return newHead[0];
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = null, curr = head, next;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        while (curr != null && prev != tail) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{prev, temp.next};
    }
}
