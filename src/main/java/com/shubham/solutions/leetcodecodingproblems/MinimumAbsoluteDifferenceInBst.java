package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">Problem link (LC-530)</a>
 */
public class MinimumAbsoluteDifferenceInBst {
    private int prev = -1;

    /**
     * Time complexity = O(N)<br>
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int diff1 = getMinimumDifference(root.left);
        int diff3 = Integer.MAX_VALUE;
        if (prev != -1) {
            diff3 = Math.abs(root.val - prev);
            prev = root.val;
        }
        int diff2 = getMinimumDifference(root.right);
        return Math.min(diff1, Math.min(diff2, diff3));
    }
}
