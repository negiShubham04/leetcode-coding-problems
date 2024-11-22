package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle">Problem link (LC-141)</a>
 */
public class LinkedListCycle {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)<br>
     * Approach used = Slow and fast pointer
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast && fast != null && fast.next != null);
        return slow == fast;
    }
}
