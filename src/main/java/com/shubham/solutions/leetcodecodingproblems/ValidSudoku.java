package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku">Problem link (LC-36)</a>
 */
public class ValidSudoku {
    /**
     * Time complexity = O(Row * Col) <br>
     * Space complexity = O(Row * Col) <br>
     * Approach used = Hashing
     */
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Map<String, Set<Character>> subMatrix = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        int i, j;
        for (i = 0; i < row; i++) {
            if (!rowMap.containsKey(i)) {
                rowMap.put(i, new HashSet<>());
            }
            for (j = 0; j < col; j++) {
                if (!colMap.containsKey(j)) {
                    colMap.put(j, new HashSet<>());
                }
                String key = i / 3 + "-" + j / 3;
                if (isInvalid(board[i][j])) {
                    continue;
                }
                if (rowMap.get(i).contains(board[i][j])) {
                    return false;
                } else {
                    rowMap.get(i).add(board[i][j]);
                }
                if (colMap.get(j).contains(board[i][j])) {
                    return false;
                } else {
                    colMap.get(j).add(board[i][j]);
                }
                if (!subMatrix.containsKey(key)) {
                    subMatrix.put(key, new HashSet<>());
                }
                if (subMatrix.get(key).contains(board[i][j])) {
                    return false;
                }
                subMatrix.get(key).add(board[i][j]);
            }
        }
        return true;
    }

    private boolean isInvalid(char c) {
        return c == '.';
    }
}
