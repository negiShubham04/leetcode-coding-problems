package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions//">Problem link (LC-130)</a>
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int i, j = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                // Add all boundary 0 to queue
                queue.add(new int[] {i, 0});
            }
            if (board[i][col - 1] == 'O') {
                // Add all boundary 0 to queue
                queue.add(new int[] {i, col - 1});
            }
        }
        for (j = 1; j < col - 1; j++) {
            if (board[0][j] == 'O') {
                // Add all boundary 0 to queue
                queue.add(new int[] {0, j});
            }
            if (board[row - 1][j] == 'O') {
                // Add all boundary 0 to queue
                queue.add(new int[] {row - 1, j});
            }
        }
        Set<String> vis = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            // convert boundary O to Y
            board[top[0]][top[1]] = 'Y';
            for (int[] d : dir) {
                int x = top[0] + d[0];
                int y = top[1] + d[1];
                if (isValid(x, y, row, col) && board[x][y] == 'O' && !vis.contains(x + "-" + y)) {
                    vis.add(x + "-" + y);
                    queue.add(new int[] {x, y});
                }
            }
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    // convert the zeroes that couldn't be converted by boundary zero to X
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    // convert the boundary attached zeroes to 0 back
                    board[i][j] = 'O';
                }

            }
        }
    }

    private boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
