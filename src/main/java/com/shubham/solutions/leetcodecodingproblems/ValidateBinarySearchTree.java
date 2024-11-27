package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree">Problem link (LC-98)</a>
 */
public class ValidateBinarySearchTree {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     */
    public boolean isValidBST(TreeNode root) {
        // long min and max is considered because Integer min and max can be possible values of
        // a node
        return findIsValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean findIsValidBst(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        boolean isValid = root.val > minValue && root.val < maxValue;
        return isValid && findIsValidBst(root.left, minValue, root.val) && findIsValidBst(root.right, root.val, maxValue);
    }
}
