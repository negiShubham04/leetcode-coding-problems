package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/symmetric-tree">Problem link (LC-101)</a>
 */
public class SymmetricTree {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) [Recursion stack]<br>
     * Approach used = Recursion
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return findIsSymmetric(root.left, root.right);
    }

    private boolean findIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && findIsSymmetric(left.left, right.right) && findIsSymmetric(left.right, right.left);
    }
}
