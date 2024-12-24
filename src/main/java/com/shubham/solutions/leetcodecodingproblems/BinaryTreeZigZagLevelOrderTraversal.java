package com.shubham.solutions.leetcodecodingproblems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">Problem link (LC-103)</a>
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    /**
     * TC = O(N)  <br>
     * SC = O(N)  <br>
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            Deque<Integer> current = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (count % 2 == 0) {
                    current.addLast(node.val);
                } else {
                    current.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(current.stream().toList());
            count++;
        }
        return ans;
    }
}
