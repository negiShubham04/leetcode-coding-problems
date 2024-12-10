package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/jump-game">Problem link (LC-55)</a>
 */
public class JumpGame {

    /**
     * Time Complexity= O(N)<br>
     * Space Complexity= O(1)<br>
     * Approach : Greedy
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int i, maxIndex = 0;
        for (i = 0; i < len; i++) {
            if (i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return maxIndex >= len - 1;
    }
}
