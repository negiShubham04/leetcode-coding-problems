package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/invert-binary-tree">Problem link (LC-226)</a>
 */
public class InvertBinaryTree {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(max depth of tree) : Recursion stack<br>
     * Approach used = Recursion.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
