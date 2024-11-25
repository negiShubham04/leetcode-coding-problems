package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii">Problem link (LC-92)</a>
 */

public class RotateList {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        int numNodes = 0;

        ListNode temp = head;
        ListNode lastNode = null;
        while (temp != null) {
            if (temp.next == null) {
                lastNode = temp;
            }
            temp = temp.next;
            numNodes++;
        }
        if (numNodes == 0) return head;
        k = k % numNodes;
        if (k == 0) return head;
        int count = 1;
        ListNode oldHead = head;
        while (count < numNodes - k) {
            head = head.next;
            count++;
        }
        ListNode nex = head.next;
        head.next = null;
        if (lastNode != null) {
            lastNode.next = oldHead;
        }
        return nex;
    }
}
