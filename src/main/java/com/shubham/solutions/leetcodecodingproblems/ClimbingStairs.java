package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs">Problem link (LC-70)</a>
 */
public class ClimbingStairs {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) excluding the returned data set <br>
     * Approach used = Dynamic programming
     */
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
}
