package com.shubham.solutions.leetcodecodingproblems;

public class NQueensII {
    final static char DEFAULT_CHAR_VALUE = '\u0000';

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        return findTotalNQueens(board, n, 0);
    }

    private int findTotalNQueens(char[][] board, int queens, int row) {
        if (row >= board.length) {
            return queens <= 0 ? 1 : 0;
        }
        int ans = 0;
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (canPlace(board, i, j)) {
                    board[i][j] = 'Q';
                    int value = findTotalNQueens(board, queens - 1, i + 1);

                    ans += value;
                    board[i][j] = DEFAULT_CHAR_VALUE;
                }
            }
        }
        return ans;
    }

    private boolean canPlace(char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;
        int i, j;
        for (i = 0; i < row; i++) {
            if (i != x) {
                if (board[i][y] == 'Q') {
                    return false;
                }
            }
        }
        for (j = 0; j < col; j++) {
            if (j != y) {
                if (board[x][j] == 'Q') {
                    return false;
                }
            }
        }
        i = x - 1;
        j = y - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        i = x + 1;
        j = y + 1;
        while (i < row && j < col) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }


        i = x - 1;
        j = y + 1;
        while (i >= 0 && j < col) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        i = x + 1;
        j = y - 1;
        while (i < row && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
