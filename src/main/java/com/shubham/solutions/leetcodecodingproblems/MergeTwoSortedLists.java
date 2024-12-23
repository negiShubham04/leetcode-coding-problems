package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists">Problem link (LC-21)</a>
 */
public class MergeTwoSortedLists {

    /**
     * TC = O(N) <br>
     * SC = O(1)  <br>
     */
    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;
        if (first.val > second.val) return mergeTwoLists(second, first);
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
