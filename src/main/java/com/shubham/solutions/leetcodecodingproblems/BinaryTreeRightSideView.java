package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view">Problem link (LC-199)</a>
 */
public class BinaryTreeRightSideView {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int i;
            for (i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (i == 0) {
                    ans.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return ans;
    }
}
