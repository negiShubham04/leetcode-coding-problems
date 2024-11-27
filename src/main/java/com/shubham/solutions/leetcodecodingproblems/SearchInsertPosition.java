package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/search-insert-position">Problem link (LC-35)</a>
 */
public class SearchInsertPosition {

    /**
     * Time complexity = O(Log N) <br>
     * Space complexity = O(1) <br>
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid-1;
            }
        }
        return low;
    }
}
