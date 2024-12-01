package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/number-of-1-bits">Problem link (LC-191)</a>
 */
public class NumberOf1Bits {

    /**
     * Time Complexity= O(1)<br>
     * Approach : Bit manipulation
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            int val = n & 1;
            if (val == 1) count++;
            n = n >> 1;
        }
        return count;
    }
}
