package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string">LC-3438</a>
 */
public class FindValidPairOfAdjacentDigits {

    public String findValidPair(String s) {
        int len = s.length();
        String ans = "";
        int i;
        Map<Integer, Integer> freq = new HashMap<>();
        for (i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            freq.put(digit, freq.getOrDefault(digit, 0) + 1);
        }
        for (i = 0; i < len; i++) {
            if (i + 1 < len && s.charAt(i) != s.charAt(i + 1)) {
                int first = s.charAt(i) - '0';
                int second = s.charAt(i + 1) - '0';
                if (freq.containsKey(first) && freq.containsKey(second)) {
                    if (first != second) {
                        if (freq.get(first) == first && freq.get(second) == second) return first + "" + second;
                    }
                }
            }
        }
        return ans;
    }
}
