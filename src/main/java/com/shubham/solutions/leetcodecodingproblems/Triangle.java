package com.shubham.solutions.leetcodecodingproblems;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/triangle">Problem link (LC-120)</a>
 */
public class Triangle {

    /**
     * Time Complexity= O(N*N)<br>
     * Space Complexity= O(N*N)<br>
     * Approach : Dynamic programming
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int i, j, len = triangle.size();
        int[][] arr = new int[len][len];
        for (j = 0; j < len; j++) {
            List<Integer> list = triangle.get(len - 1);
            if (list.size() > j) {
                arr[len - 1][j] = list.get(j);
            }
        }
        for (i = len - 2; i >= 0; i--) {
            for (j = 0; j < len; j++) {
                if (j < triangle.get(i).size()) {
                    arr[i][j] = triangle.get(i).get(j) + Math.min(arr[i + 1][j], arr[i + 1][j + 1]);
                }
            }
        }
        return arr[0][0];
    }
}
