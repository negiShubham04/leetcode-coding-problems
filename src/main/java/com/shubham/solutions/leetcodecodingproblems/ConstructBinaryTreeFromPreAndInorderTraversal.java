package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">Problem link (LC-105)</a>
 */
public class ConstructBinaryTreeFromPreAndInorderTraversal {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeToPositionInOrder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeToPositionInOrder.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, nodeToPositionInOrder);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> nodeToPositionInOrder) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int position = nodeToPositionInOrder.get(preorder[preStart]);
        int elementsInLeft = position - inStart + 1;
        node.left = buildTree(preorder, preStart + 1, preStart + elementsInLeft - 1, inStart, position - 1, nodeToPositionInOrder);
        node.right = buildTree(preorder, preStart + elementsInLeft, preEnd, position + 1, inEnd, nodeToPositionInOrder);
        return node;
    }
}
