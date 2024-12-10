package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/happy-number/">Problem link (LC-202)</a>
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = getSquareOfDigits(n);
        }
    }

    private int getSquareOfDigits(int n) {
        String s = String.valueOf(n);
        int i, len = s.length();
        int sum = 0;
        for (i = 0; i < len; i++) {
            sum += (int) Math.pow(s.charAt(i) - '0', 2);
        }
        return sum;
    }
}
