package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/house-robber/">Problem link (LC-198)</a>
 */
public class HouseRobber {

    /**
     * TC = O(N)<br>
     * SC = O(1)<br>
     * Approach = DP
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n + 1];
        int i;
        cache[n - 1] = nums[n - 1];
        for (i = n - 2; i >= 0; i--) {
            cache[i] = Math.max(nums[i] + cache[i + 2], cache[i + 1]);
        }
        return cache[0];
    }
}
