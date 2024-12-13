package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence">Problem link (LC-300)</a>
 */
public class LongestIncreasingSubsequence {

    /**
     * TC = O(N)<br>
     * SC = O(N)<br>
     * Approach = DP
     */
    public int lengthOfLIS(int[] nums) {
        int i, n = nums.length;
        int[] lengthOfLis = new int[n];
        lengthOfLis[n - 1] = 1;
        for (i = n - 2; i >= 0; i--) {
            int ans = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    ans = Math.max(ans, 1 + lengthOfLis[j]);
                }
            }
            lengthOfLis[i] = ans;
        }
        int maxLen = 1;
        for (int len : lengthOfLis) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
