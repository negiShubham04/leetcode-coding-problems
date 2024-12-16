package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/partition-list/">Problem link (LC-86)</a>
 */
public class PartitionList {

    /**
     * TC = O(N)<br>
     * SC = O(1) <br>
     * Linked list operations [Pointer]
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = null;
        ListNode firstHead = null;
        ListNode second = null;
        ListNode firstEnd = null;
        ListNode secondStart = null;
        while (head != null) {
            if (head.val < x) {
                if (first == null) {
                    first = head;
                    firstHead = head;
                } else {
                    first.next = head;
                    first = first.next;
                }
                firstEnd = first;
            } else {
                if (second == null) {
                    second = head;
                    secondStart = second;
                } else {
                    second.next = head;
                    second = second.next;
                }
            }
            head = head.next;
        }
        if (second != null) {
            second.next = null;
        }
        if (first != null) {
            first.next = null;
        }
        if (firstEnd != null) {
            firstEnd.next = secondStart;
            return firstHead;
        } else {
            return secondStart;
        }
    }
}
