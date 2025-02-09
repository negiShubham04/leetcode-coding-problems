package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;
/**
 * <a href="https://leetcode.com/problems/sort-matrix-by-diagonals/">Problem link (LC-3446)</a>
 */
public class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[row][col];
        int i, j;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                int diff = i - j;
                map.computeIfAbsent(diff, x -> new ArrayList<>()).add(grid[i][j]);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int diff = entry.getKey();
            List<Integer> list = entry.getValue();
            if (diff == 0) {
                list.sort((o1, o2) -> Integer.compare(o2, o1));
                i = 0;
                j = 0;
            } else if (diff < 0) {
                list.sort(Comparator.comparingInt(o -> o));
                i = 0;
                j = -diff;
            } else {
                list.sort((o1, o2) -> Integer.compare(o2, o1));
                i = diff;
                j = 0;
            }
            while (i < row && j < col) {
                for (int x : list) {
                    ans[i][j] = x;
                    i++;
                    j++;
                }
            }
        }
        return ans;
    }
}
