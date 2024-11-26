package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list">Problem link (LC-19)</a>
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int numNodes = 0;
        ListNode temp = head;
        while (temp != null) {
            numNodes++;
            temp = temp.next;
        }
        int index = numNodes - n;
        if (index == 0) {
            return head.next;
        }
        int count = 0;
        temp = head;
        while (count < index - 1) {
            count++;
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }
}
