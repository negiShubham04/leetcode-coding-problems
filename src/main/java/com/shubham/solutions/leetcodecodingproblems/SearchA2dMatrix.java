package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix">Problem link (LC-74)</a>
 */
public class SearchA2dMatrix {

    /**
     * Time complexity = O(N*M Log (N*M)) <br>
     * Space complexity = O(1)<br>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0, high = row * col - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            // convert 1d index to 2d coordinate
            int y = mid % col;
            int x = mid / col;
            int val = matrix[x][y];
            if (val == target) {
                return true;
            } else if (target < val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
