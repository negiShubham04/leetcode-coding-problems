package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">Problem link (LC-6)</a>
 */
public class ZigzagConversion {
    /**
     * TC = O(N*N)  <br>
     * SC = O(N*N)  <br>
     */
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || numRows == 0) return s;
        if (len == 0 || len == 1) return s;
        if (numRows == 2) {
            return convert2(s);
        }
        int col = 2 * (int) (Math.floor((float) len / 2)) - 1;
        char[][] arr = new char[numRows][col];
        int i = 0, j = 0, index = 0;
        while (index < len) {
            if (j % 2 == 0) {
                i = 0;
                while (i < numRows && index < len) {
                    arr[i][j] = s.charAt(index++);
                    i++;
                }
                j++;
                i = numRows - 2;
            } else {
                while (i >= 1 && index < len) {
                    arr[i][j] = s.charAt(index++);
                    i--;
                }
                j++;
                i = 0;
            }
            if (j >= col) break;
        }
        String ans = "";
        for (i = 0; i < numRows; i++) {
            for (j = 0; j < col; j++) {
                if (arr[i][j] != '\u0000')
                    ans += arr[i][j];
            }

        }
        return ans;
    }

    private String convert2(String s) {
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                s1 += s.charAt(i);
            } else {
                s2 += s.charAt(i);
            }
        }

        return s1 + s2;
    }
}
