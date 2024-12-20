package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/single-number">Problem link (LC-136)</a>
 */
public class SingleNumber {

    /**
     * TC = O(N) <br>
     * SC = O(1)  <br>
     */
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums){
            xor = xor ^ num;
        }
        return xor;
    }
}
