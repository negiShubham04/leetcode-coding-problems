package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.List;

public class ZigZagGridTraversalWithSkip {

    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new LinkedList<>();
        int row = grid.length, col = grid[0].length;
        int i, j;
        boolean shouldVisit = true;
        for (i = 0; i < row; i++) {
            boolean isRight = (i % 2 == 0);
            if (isRight) {
                for (j = 0; j < col; j ++) {
                    if (shouldVisit) {
                        ans.add(grid[i][j]);
                        shouldVisit = false;
                    } else {
                        shouldVisit = true;
                    }
                }
            } else {
                for (j = col - 1; j >= 0; j --) {
                    if (shouldVisit) {
                        ans.add(grid[i][j]);
                        shouldVisit = false;
                    } else {
                        shouldVisit = true;
                    }
                }
            }
        }
        return ans;
    }
}
