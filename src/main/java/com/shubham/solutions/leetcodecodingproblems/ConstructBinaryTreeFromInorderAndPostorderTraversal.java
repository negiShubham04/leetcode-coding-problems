package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">Problem link (LC-106)</a>
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> nodeToPositionInOrder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeToPositionInOrder.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1, nodeToPositionInOrder);

    }

    private TreeNode buildTree(int[] postorder, int postStart, int postEnd, int inStart, int inEnd, Map<Integer, Integer> nodeToPositionInOrder) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(postorder[postEnd]);
        int position = nodeToPositionInOrder.get(postorder[postEnd]);
        int elementsInLeft = position - inStart;
        node.left = buildTree(postorder, postStart, postStart + elementsInLeft - 1, inStart, position - 1, nodeToPositionInOrder);
        node.right = buildTree(postorder, postStart + elementsInLeft, postEnd - 1, position + 1, inEnd, nodeToPositionInOrder);
        return node;
    }
}
