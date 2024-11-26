package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal">Problem link (LC-102)</a>
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int i;
            int size = queue.size();
            List<Integer> current = new ArrayList<>(size);
            for (i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode == null) {
                    continue;
                }
                current.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            ans.add(current);
        }
        return ans;
    }
}
