package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix">Problem link (LC-54)</a>
 */
public class SpiralMatrix {


    /**
     * Time complexity = O(N*N) <br>
     * Space complexity = O(1)<br>
     * Approach used =2-DArray traversal.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int rowStart = 0;
        int rowEnd = row - 1;
        int colStart = 0;
        int colEnd = col - 1;
        int dir = 0;
        List<Integer> ans = new LinkedList<>();
        int i, j;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            if (dir == 0) {
                for (j = colStart; j <= colEnd; j++) {
                    ans.add(matrix[rowStart][j]);
                }
                rowStart++;
            } else if (dir == 1) {
                for (i = rowStart; i <= rowEnd; i++) {
                    ans.add(matrix[i][colEnd]);
                }
                colEnd--;
            } else if (dir == 2) {
                for (j = colEnd; j >= colStart; j--) {
                    ans.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            } else {
                for (i = rowEnd; i >= rowStart; i--) {
                    ans.add(matrix[i][colStart]);
                }
                colStart++;
            }
            dir = (dir + 1) % 4;
        }
        return ans;
    }
}
