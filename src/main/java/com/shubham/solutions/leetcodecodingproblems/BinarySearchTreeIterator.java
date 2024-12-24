package com.shubham.solutions.leetcodecodingproblems;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Problem link (LC-173)</a>
 */
public class BinarySearchTreeIterator {

    /**
     * TC = O(1) for each next and hasNext operation  <br>
     * SC = O(H): Height of tree  <br>
     */
    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushInStack(root);
        }

        private void pushInStack(TreeNode root) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
        }


        public int next() {
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                pushInStack(node.right);
                return node.val;
            }
            return -1;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
