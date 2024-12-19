package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/maximum-subarray/">Problem link (LC-53)</a>
 */
public class MaximumSubarray {

    /**
     * TC = O(N) <br>
     * SC = O(1)  <br>
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 0) {
                maxSum = Math.max(maxSum, sum);
                sum = 0;
            } else {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
