package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/candy">Problem link (LC-135)</a>
 */
public class Candy {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     * Approach: prefix and suffix arrays
     */
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int i;
        left[0] = 1;
        for (i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[length - 1] = 1;
        for (i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int ans = 0;
        for (i = 0; i < length; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
}
