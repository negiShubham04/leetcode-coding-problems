package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes">Problem link (LC-73)</a>
 */
public class SetMatrixZeroes {

    /**
     * Time complexity = O(M * N) <br>
     * Space complexity = O(M + N)<br>
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rowTrack = new int[row];
        int[] colTrack = new int[col];
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowTrack[i] = 1;
                    colTrack[j] = 1;
                }
            }
        }
        for (i = 0; i < row; i++) {
            if (rowTrack[i] == 1) {
                for (j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (j = 0; j < col; j++) {
            if (colTrack[j] == 1) {
                for (i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
