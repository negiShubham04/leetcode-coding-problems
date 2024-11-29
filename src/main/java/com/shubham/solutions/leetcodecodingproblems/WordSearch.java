package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/word-search/">Problem link (LC-79)</a>
 */
public class WordSearch {

    /**
     * Time complexity = Exponential <br>
     */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int i, j;
        int[][] vis = new int[row][col];
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (isFound(word, vis, i, j, row, col, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFound(String word, int[][] vis, int i, int j, int row, int col, int index, char[][] board) {
        if (index >= word.length()) return true;
        if (i >= row || j >= col || i < 0 || j < 0) return false;
        if (index == word.length() - 1) return board[i][j] == word.charAt(index);
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        vis[i][j] = 1;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < row && y < col && x >= 0 && y >= 0) {
                if (vis[x][y] == 0 && isFound(word, vis, x, y, row, col, index + 1, board)) {
                    return true;
                }
            }
        }
        // This is important otherwise we will not be able to visit a cell which is common to two words
        // with same prefix
        // H U M A N
        // U M M
        // word = HUMMMAN
        // M at first row will be visited by H -> U -> M
        // if it mark as visited
        // we can't visit it through H -> U -> M -> M -> M -> A -> N
        // Also we can visit this cell later through some other path
        vis[i][j] = 0;

        // It can happen that we are on the last index and the char at that index match the
        // current grid character but no unvisited cells are present for that coordinate
        // This will return false in that case
        // This is base case and added above
        return false;
    }

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}
