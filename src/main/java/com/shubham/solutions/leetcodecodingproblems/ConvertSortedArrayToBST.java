package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree">Problem link (LC-108)</a>
 */
public class ConvertSortedArrayToBST {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)<br>
     * Approach used = Recursion.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int low, int high) {
        if (low > high) return null;
        if (low == high) {
            return new TreeNode(nums[low]);
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, low, mid - 1);
        node.right = constructBST(nums, mid + 1, high);
        return node;
    }
}
