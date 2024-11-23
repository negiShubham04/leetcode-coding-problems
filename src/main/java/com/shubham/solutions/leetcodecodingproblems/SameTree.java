package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/same-tree">Problem link (LC-100)</a>
 */
public class SameTree {

    /**
     * Time complexity = O(Number of nodes) <br>
     * Space complexity = O(max depth of tree) <br>
     * Approach used = recursion
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
