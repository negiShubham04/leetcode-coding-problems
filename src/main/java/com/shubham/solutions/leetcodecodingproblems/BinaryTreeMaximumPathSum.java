package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Problem link (LC-124)</a>
 */
public class BinaryTreeMaximumPathSum {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)[recursion stack] <br>
     */
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        findMaxPathSum(root, ans);
        return ans[0];
    }

    private int findMaxPathSum(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(findMaxPathSum(node.left, ans), 0);
        int right = Math.max(findMaxPathSum(node.right, ans), 0);
        ans[0] = Math.max(ans[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
