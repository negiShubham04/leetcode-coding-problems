package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/sum-of-variable-length-subarrays">LINK</a>>
 */
public class SumOfVariableLengthSubarrays {

    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int i;
        prefixSum[0] = nums[0];
        for (i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int ans = 0;
        for (i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            if (start == 0) {
                ans += prefixSum[i];
            } else {
                ans += (prefixSum[i] - prefixSum[start] + nums[start]);
            }
        }
        return ans;
    }
}
