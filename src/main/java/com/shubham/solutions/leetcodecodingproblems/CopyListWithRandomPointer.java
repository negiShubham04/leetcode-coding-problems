package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Problem link (LC-138)</a>
 */
public class CopyListWithRandomPointer {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewNode = new HashMap<>();
        if (head == null) return null;
        Node newHead = new Node(-1);
        while (head != null) {
            Node oldNext = head.next;
            Node oldRandom = head.random;
            Node currNew = new Node(head.val);
            if (oldToNewNode.containsKey(head)) {
                currNew = oldToNewNode.get(head);
            } else {
                oldToNewNode.put(head, currNew);
            }
            if (newHead.next == null) {
                newHead.next = currNew;
            }
            currNew.random = getNode(oldToNewNode, oldRandom);
            currNew.next = getNode(oldToNewNode, oldNext);
            head = head.next;
        }
        return newHead.next;
    }

    private Node getNode(Map<Node, Node> oldToNewNode, Node oldNext) {
        Node newNode = null;
        if (oldNext != null) {
            if (oldToNewNode.containsKey(oldNext)) {
                newNode = oldToNewNode.get(oldNext);
            } else {
                newNode = new Node(oldNext.val);
                oldToNewNode.put(oldNext, newNode);
            }
        }
        return newNode;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


}
