package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/game-of-life">Problem link (LC-289)</a>
 */
public class GameOfLife {

    /**
     * Time complexity = O (M*N)<br>
     * Number from 0 to 3 when represented in binary can represent
     * four states<br>
     *  Old   -> New   = Value <br>
     *  0     -> 0    =  0 <br>
     *  1     ->  0    =  1 <br>
     *  0     ->  1    =  2 <br>
     *  1     ->  1   =   3 <br>
     */
    public void gameOfLife(int[][] board) {
        int row = board.length, col = board[0].length;
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                int oldValue = getOriginalValue(board[i][j]);
                int newValue = calculate(board, i, j);
                if (oldValue == 0) {
                    board[i][j] = (newValue == 0 ? 0 : 2);
                } else {
                    board[i][j] = (newValue == 0 ? 1 : 3);
                }
            }
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int calculate(int[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        int live = 0;
        int originalValue;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isValid(x, y, row, col)) {
                originalValue = getOriginalValue(board[x][y]);
                if (originalValue == 1) live++;
            }
        }
        originalValue = getOriginalValue(board[i][j]);
        if (originalValue == 1) {
            if (live < 2) return 0;
            else if (live <= 3) return 1;
            else return 0;
        } else {
            return live == 3 ? 1 : 0;
        }
    }

    private int getOriginalValue(int x) {
        if (x == 2) {
            return 0;
        } else if (x == 3) {
            return 1;
        }
        return x;
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
}
