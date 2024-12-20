package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/minimum-path-sum/">Problem link (LC-64)</a>
 */
public class MinimumPathSum {

    /**
     * TC = O(N*M) <br>
     * SC = O(N*M)  <br>
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i, j;
        int[][] ans = new int[row][col];
        ans[row - 1][col - 1] = grid[row - 1][col - 1];
        for (i = row - 1; i >= 0; i--) {
            for (j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) continue;
                int down = i + 1 < row ? ans[i + 1][j] : -1;
                int right = j + 1 < col ? ans[i][j + 1] : -1;
                ans[i][j] = Integer.MAX_VALUE;
                if (down != -1) {
                    ans[i][j] = Math.min(ans[i][j], grid[i][j] + down);
                }
                if (right != -1) {
                    ans[i][j] = Math.min(ans[i][j], grid[i][j] + right);
                }
            }
        }
        return ans[0][0];
    }
}
