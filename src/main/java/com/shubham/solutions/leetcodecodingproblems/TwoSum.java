package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum">Problem link (LC-1)</a>
 */
public class TwoSum {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     * Approach used = Hashing
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int i;
        for (i = 0; i < n; i++) {
            int val = target - nums[i];
            if (valueToIndex.containsKey(val)) {
                return new int[]{i, valueToIndex.get(val)};
            }
            valueToIndex.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
