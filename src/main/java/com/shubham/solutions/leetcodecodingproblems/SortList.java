package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/sort-list/">Problem link (LC-148)</a>
 */
public class SortList {

    /**
     * TC = O(N Log N) <br>
     * SC = O(Log N)  <br>
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        do {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null);
        prev.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(slow);
        return merge(firstHalf, secondHalf);
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.val > second.val) return merge(second, first);
        ListNode head = new ListNode(-1);
        head.next = first;
        while (first != null && second != null) {
            while (first != null && first.next != null && first.next.val <= second.val) {
                first = first.next;
            }
            if (first != null) {
                ListNode firstNext = first.next;
                first.next = second;
                first = firstNext;
            }
            if (first != null && second != null && first.val > second.val) {
                ListNode temp = first;
                first = second;
                second = temp;
            }
        }
        if (first != null) {
            first.next = second;
        }
        return head.next;
    }

}
