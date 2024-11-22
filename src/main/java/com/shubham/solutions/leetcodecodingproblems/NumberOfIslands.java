package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/number-of-islands">Problem link (LC-200)</a>
 */
public class NumberOfIslands {

    /**
     * Time complexity = O(N*N) <br>
     * Space complexity = O(N*N)<br>
     * Approach used = DFS
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i, j;
        int[][] vis = new int[row][col];
        int count = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (grid[i][j] == '0' || vis[i][j] == 1) continue;
                count = count + dfs(grid, i, j, vis);
            }
        }
        return count;
    }

    private int dfs(char[][] grid, int i, int j, int[][] vis) {
        if (vis[i][j] == 1) return 0;
        vis[i][j] = 1;
        for (int[] direction : DIRECTION_COORDINATES) {
            int xCoordinate = i + direction[0];
            int yCoordinate = j + direction[1];
            if (isValid(xCoordinate, yCoordinate, grid.length, grid[0].length) && grid[xCoordinate][yCoordinate] == '1' && vis[xCoordinate][yCoordinate] == 0) {
                dfs(grid, xCoordinate, yCoordinate, vis);
            }
        }
        return 1;
    }

    private boolean isValid(int xCoordinate, int yCoordinate, int row, int col) {
        return xCoordinate >= 0 && xCoordinate < row && yCoordinate >= 0 && yCoordinate < col;
    }

    final int[][] DIRECTION_COORDINATES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}
