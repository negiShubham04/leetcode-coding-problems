package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array">Problem link (LC-153)</a>
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * TC = O(Log N) <br>
     * SC = O(1)  <br>
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            mid = (low + high) / 2;
            min = Integer.min(nums[mid], min);
            if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }
}
