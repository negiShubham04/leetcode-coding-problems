package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum">Problem link (LC-209)</a>
 */
public class MinimumSizeSubarraySum {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach used = Sliding window.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, len = nums.length;
        int j = 0;
        int sum = 0;
        int minLen = len + 1;
        while (j < len) {
            sum += nums[j];
            if (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);
                while (i <= j && sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
            }
            j++;
        }
        return minLen == len + 1 ? 0 : minLen;
    }
}
