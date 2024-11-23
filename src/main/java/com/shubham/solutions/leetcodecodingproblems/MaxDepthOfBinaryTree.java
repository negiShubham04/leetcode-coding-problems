package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">Problem link (LC-104)</a>
 */
public class MaxDepthOfBinaryTree {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(max depth of tree)<br>
     * Approach used = recursion
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
