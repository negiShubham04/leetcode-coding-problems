package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii">Problem link (LC-82)</a>
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * TC = O(N)<br>
     * SC = O(1) <br>
     * Linked list operations
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        ListNode prev = null;
        ListNode first = head;
        ListNode second = head;
        while (second != null && first != null) {
            while (second.next != null && second.val == second.next.val) {
                second = second.next;
            }
            if (first == second) {
                if (prev == null) {
                    newHead = first;
                } else {
                    prev.next = first;
                }
                prev = first;
                first = prev.next;
            } else {
                first = second.next;
            }
            second = first;
        }
        if (prev != null) {
            // 1,1,2,3,3
            prev.next = first;
        }
        return newHead;
    }
}
