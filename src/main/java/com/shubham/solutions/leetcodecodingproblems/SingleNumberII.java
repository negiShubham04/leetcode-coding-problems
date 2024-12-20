package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/single-number-ii">Problem link (LC-137)</a>
 */
public class SingleNumberII {

    /**
     * TC = O(N) <br>
     * SC = O(N)  <br>
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() != 3) return entry.getKey();
        }
        return -1;
    }
}
