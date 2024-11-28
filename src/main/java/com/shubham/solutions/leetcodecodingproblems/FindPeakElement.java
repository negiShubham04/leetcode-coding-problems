package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/find-peak-element">Problem link (LC-162)</a>
 */
public class FindPeakElement {

    /**
     * Time complexity = O(N Log N) <br>
     * Space complexity = O(1)<br>
     */
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            long left = (mid - 1 >= 0 ? nums[mid - 1] : Long.MIN_VALUE);
            long right = (mid + 1 < nums.length ? nums[mid + 1] : Long.MIN_VALUE);
            if (nums[mid] > left && nums[mid] > right) {
                return mid;
            } else if (nums[mid] < left && nums[mid] > right) {
                high = mid - 1;
            } else {
                low  = mid + 1;
            }
        }
        return 0;
    }
}
