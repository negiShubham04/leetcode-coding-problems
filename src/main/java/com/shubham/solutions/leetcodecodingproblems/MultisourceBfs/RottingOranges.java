package com.shubham.solutions.leetcodecodingproblems.MultisourceBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/"> Rotting oranges</a>
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int i, j;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        if (queue.isEmpty()) return -1;
        int ans = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean isRot = false;
            while (n > 0) {
                int[] curr = queue.poll();
                for (int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        isRot = true;
                        fresh--;
                        queue.add(new int[]{x, y});
                    }
                }
                n--;
            }
            if (isRot)
                ans++;
        }
        return fresh == 0 ? ans : -1;
    }

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
}
