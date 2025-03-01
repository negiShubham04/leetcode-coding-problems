package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/find-the-number-of-copy-arrays/">LC-3468 </a>
 */
public class CountArrays {

    public int countArrays(int[] original, int[][] bounds) {
        int low = bounds[0][0];
        int high = bounds[0][1];
        int ans = high - low + 1;
        for(int i=1;i<original.length;i++){
            int diff = original[i]-original[i-1];
            low = Math.max(low+diff, bounds[i][0]);
            high = Math.min(high+diff, bounds[i][1]);
            ans = Math.min(ans, high-low+1);
        }
        return Math.max(ans, 0);
    }
}
