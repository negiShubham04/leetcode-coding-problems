package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst">Problem link (LC-230)</a>
 */
public class KthSmallestElementInBst {

    /**
     * TC = O(N)<br>
     * SC = O(N) [Recursion stack] <br>
     */
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallest(root, k, new int[]{0});
    }

    private int findKthSmallest(TreeNode root, int k, int[] count) {
        if (root == null) {
            return -1;
        }
        if (count[0] == k) {
            return root.val;
        }
        int leftVal = findKthSmallest(root.left, k, count);
        if (leftVal != -1) {
            return leftVal;
        }
        count[0]++;
        if (count[0] == k) {
            return root.val;
        }
        return findKthSmallest(root.right, k, count);
    }
}
