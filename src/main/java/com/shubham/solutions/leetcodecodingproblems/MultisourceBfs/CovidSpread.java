package com.shubham.solutions.leetcodecodingproblems.MultisourceBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://www.geeksforgeeks.org/problems/covid-spread--141631/1"> Covid Spread</a>
 */
public class CovidSpread {
    public int covidSpread(int[][] hospital) {
        int row = hospital.length;
        int col = hospital[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int i, j;
        int countUninfected = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (hospital[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (hospital[i][j] == 1) {
                    countUninfected++;
                }
            }
        }
        if (countUninfected == 0) return 0;
        if (queue.isEmpty()) {
            return -1;
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean isInfected = false;
            while (n > 0) {
                int curr[] = queue.poll();

                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (isValid(x, y, row, col) && hospital[x][y] == 1) {
                        countUninfected--;
                        isInfected = true;
                        hospital[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }

                n--;
            }
            if (isInfected) time++;

        }
        return countUninfected == 0 ? time : -1;
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
