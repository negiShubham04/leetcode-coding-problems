package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii">Problem link (LC-92)</a>
 */
public class ReverseLinkedListII {
    /**
     * TC = O(1)<br>
     * SC = O(1) [Excluding recursion stack]<br>
     * Linked list operations
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode leftPrev = null;
        ListNode rightNext = null;
        ListNode newHead = null;
        int count = 1;
        // find pointer previous to `left`
        // and pointer next to `right`
        while (temp != null) {
            if ((count + 1) == left) {
                leftPrev = temp;
                newHead = temp.next;
            }
            if (count == right) {
                rightNext = temp.next;
                temp.next = null;
            }
            count++;
            temp = temp.next;
        }
        ListNode[] arr = new ListNode[2];
        if (newHead == null) {
            // left pointer is head
            newHead = head;
            reverse(null, newHead, arr);
            if (arr[1] != null)
                arr[1].next = rightNext;
            return arr[0];
        }
        reverse(null, newHead, arr);
        if (leftPrev != null)
            leftPrev.next = arr[0];
        if (arr[1] != null)
            arr[1].next = rightNext;
        return head;
    }

    private void reverse(ListNode prev, ListNode current, ListNode[] arr) {
        if (current == null) {
            // contains new head of reversed list
            arr[0] = prev;
            return;
        }
        reverse(current, current.next, arr);
        if (prev == null) {
            // contains new tail of reversed list
            arr[1] = current;
        }
        current.next = prev;
    }
}
