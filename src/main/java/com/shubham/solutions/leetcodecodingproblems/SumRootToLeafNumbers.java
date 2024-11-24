package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers">Problem link (LC-129)</a>
 */
public class SumRootToLeafNumbers {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(max depth of tree) : Recursion stack + space to store string<br>
     * Approach used = Recursion.
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers2(root, "");
    }

    private int sumNumbers2(TreeNode root, String value) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            value += root.val;
            return Integer.parseInt(value);
        }
        return sumNumbers2(root.left, value + root.val) +
                sumNumbers2(root.right, value + root.val);
    }
}
