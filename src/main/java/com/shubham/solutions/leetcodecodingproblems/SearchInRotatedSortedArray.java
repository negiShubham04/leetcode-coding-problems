package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array">Problem link (LC-33)</a>
 */
public class SearchInRotatedSortedArray {

    /**
     * TC = O(Log N) <br>
     * SC = O(1)  <br>
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[high]) {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
