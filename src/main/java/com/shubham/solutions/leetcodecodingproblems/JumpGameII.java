package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii">Problem link (LC-45)</a>
 */
public class JumpGameII {

    /**
     * TC = O(N)<br>
     * SC = O(N)<br>
     * Dynamic programming
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int i;
        int[] arr = new int[len];
        arr[len - 1] = 0;
        for (i = len - 2; i >= 0; i--) {
            int count = 1;
            int min = Integer.MAX_VALUE;
            while (count <= nums[i] && i + count < len) {
                int index = i + count;
                min = Math.min(min, 1 + arr[index]);
                count++;
            }
            arr[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE-1: min);
        }
        return arr[0];
    }
}
