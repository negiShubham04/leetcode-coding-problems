package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array">LINK</a>
 */
public class MaxDiffBetweenAdjElementsInCircularSubArray {

    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;
        int i;
        int maxDiff = Integer.MIN_VALUE;
        for (i = 0; i < len; i++) {
            int next = (i + 1 < len ? i + 1 : 0);
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[next]));
        }
        return maxDiff;
    }
}
