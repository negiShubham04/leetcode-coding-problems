package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list">Problem link (LC-114)</a>
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * TC = O(N) <br>
     * SC = O(N) [Recursion stack]  <br>
     */
    public void flatten(TreeNode root) {
        flatten2(root);
    }

    public TreeNode flatten2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newLeft = flatten2(root.left);
        TreeNode newRight = flatten2(root.right);
        root.right = newLeft;
        root.left = null;
        attachToLast(root, newRight);
        return root;
    }

    private void attachToLast(TreeNode root, TreeNode prevRight) {
        while (root != null && root.right != null) {
            root = root.right;
        }
        if (root != null) {
            root.right = prevRight;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
