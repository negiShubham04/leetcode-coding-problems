package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/edit-distance/">link</a>
 */
public class EditDistance {

    public int editDistance(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] arr = new int[len1 + 1][len2 + 1];
        int i, j;
        // Converted top-down (memoized code) to bottom up (Tabulation) method
        for (i = 0; i < len1 + 1; i++) {
            for (j = 0; j < len2 + 1; j++) {
                if (i == len1 && j == len2) {
                    arr[i][j] = 0;
                } else if (i == len1) {
                    arr[i][j] = len2 - j;
                } else if (j == len2) {
                    arr[i][j] = len1 - i;
                }
            }
        }
        for (i = len1 - 1; i >= 0; i--) {
            for (j = len2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    arr[i][j] = arr[i + 1][j + 1];
                } else {
                    int insert = 1 + arr[i][j + 1];
                    int delete = 1 + arr[i + 1][j];
                    int replace = 1 + arr[i + 1][j + 1];
                    arr[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return arr[0][0];
    }
}
