package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate-ii">Problem link (LC-219)</a>
 */
public class ContainsDuplicateII {


    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)<br>
     * Approach used = Hashing.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int i, len = nums.length;
        for (i = 0; i < len; i++) {
            if (!valueToIndex.containsKey(nums[i])) {
                valueToIndex.put(nums[i], i);
            } else {
                int prevIndex = valueToIndex.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
                // There is no point in storing the other older index
                // store current index
                valueToIndex.put(nums[i], i);
            }
        }
        return false;
    }
}
