package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/majority-element">Problem link (LC-169)</a>
 */
public class MajorityElement {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach used = Moore's voting algorithm
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int i;
        int count = 1;
        int element = nums[0];
        // Treat first element as majority
        for (i = 1; i < n; i++) {
            if (nums[i] == element) {
                // vote up
                count++;
            } else {
                // vote down
                count--;
            }
            if (count == 0) {
                count = 1;
                // new candidate for majority element
                element = nums[i];
            }
        }
        return element;
    }
}
