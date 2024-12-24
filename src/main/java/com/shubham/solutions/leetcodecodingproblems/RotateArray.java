package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">Problem link (LC-189)</a>
 */
public class RotateArray {

    /**
     * TC = O(N)  <br>
     * SC = O(1)  <br>
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        int mid = n - k;
        reverse(nums, 0, mid - 1);
        reverse(nums, mid, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
