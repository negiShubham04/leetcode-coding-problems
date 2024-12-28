package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/count-complete-tree-nodes">Problem link (LC-222)</a>
 */
public class CountCompleteTreeNodes {

    /**
     * Time complexity = O(LogN * LogN) <br>
     * Space complexity = O(Log N) <br>
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            // This means that tree is full
            //    1
            //   /  \
            //  3    4
            return (int) (Math.pow(2, leftHeight) - 1);
        }
        // leftHeight = 3
        // rightHeight = 2
        //        1
        //       /  \
        //      3    4
        //     / \
        //     5  6
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode node) {
        int count = 0;
        while (node != null) {
            node = node.left;
            count++;
        }
        return count;
    }


    private int rightHeight(TreeNode node) {
        int count = 0;
        while (node != null) {
            node = node.right;
            count++;
        }
        return count;
    }
}
