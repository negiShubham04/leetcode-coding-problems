package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * <a href="https://leetcode.com/problems/average-of-levels-in-binary-tree">Problem link (LC-637)</a>
 */
public class AverageOfLevelsInBinaryTree {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return List.of();
        List<Double> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i;
            double sum = 0;
            for (i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    continue;
                }
                sum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }
}
