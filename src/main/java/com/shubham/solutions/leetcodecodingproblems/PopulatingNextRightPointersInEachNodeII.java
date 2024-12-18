package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">Problem link (LC-117)</a>
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * TC = O(N) <br>
     * SC = O(N)  <br>
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i;
            Node prev = null;
            for (i = 0; i < size; i++) {
                Node node = queue.poll();
                if (prev != null) {
                    node.next = prev;
                }
                prev = node;
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
