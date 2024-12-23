package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">Problem link (LC-23)</a>
 */
public class MergeKSortedLists {

    /**
     * TC = O(N LogK) where N is the avg size of each list and k is the number of lists <br>
     * SC = O(LogK + N)  <br>
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return funMergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode funMergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = (start + end) / 2;
        // Just like binary search
        // split into two halves
        ListNode left = funMergeKLists(lists, start, mid - 1);
        ListNode right = funMergeKLists(lists, mid, end);
        return mergeTwoLists(left, right);
    }


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
