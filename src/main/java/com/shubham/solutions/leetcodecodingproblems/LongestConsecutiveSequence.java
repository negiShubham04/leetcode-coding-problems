package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence">Problem link (LC-128)</a>
 */
public class LongestConsecutiveSequence {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) [Worst case]
     * Approach used = Hashset and checking if the element is start of the longest sequence
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i;
        int n = nums.length;
        if (n == 0) return 0;
        for (i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int val = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            int prev = nums[i] - 1;
            // [3,4,5]
            if (set.contains(prev)) {
                // if prev = 3 or 4
                continue;
            }
            int next = nums[i] + 1;
            int count = 1;
            while (set.contains(next)) {
                count++;
                next++;
            }
            val = Math.max(count, val);
        }
        return val;
    }
}
