package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/path-sum">Problem link (LC-112)</a>
 */
public class PathSum {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(max depth of tree) : Recursion stack <br>
     * Approach used = Recursion.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum2(root, targetSum);
    }

    private boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            targetSum -= root.val;
            return targetSum == 0;
        }
        boolean left = hasPathSum2(root.left, targetSum - root.val);
        if (left) return true;
        return hasPathSum2(root.right, targetSum - root.val);
    }
}
