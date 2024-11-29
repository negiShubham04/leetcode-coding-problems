package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">Problem link (LC-48)</a>
 */
public class RotateImage {

    /**
     * Time complexity = O(M * N) <br>
     * Space complexity = O(1)<br>
     */
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i, j, temp;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (i < j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for (i = 0; i < row; i++) {
            int low = 0, high = col - 1;
            while (low < high) {
                temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
}
