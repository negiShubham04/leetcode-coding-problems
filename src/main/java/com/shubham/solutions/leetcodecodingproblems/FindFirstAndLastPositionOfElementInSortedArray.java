package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array">Problem link (LC-34)</a>
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Time complexity = O (LogN).
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] ans = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        binarySearch(0, len - 1, ans, nums, target);
        if (ans[0] == Integer.MAX_VALUE) {
            ans[0] = -1;
        }
        if (ans[1] == Integer.MIN_VALUE) {
            ans[1] = -1;
        }
        return ans;
    }

    private void binarySearch(int low, int high, int[] ans, int[] nums, int target) {
        if (low > high) return;
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            ans[0] = Math.min(ans[0], mid);
            ans[1] = Math.max(ans[1], mid);
            if (mid + 1 < nums.length && nums[mid + 1] == target) {
                binarySearch(mid + 1, high, ans, nums, target);
            }
            if (mid - 1 >= 0 && nums[mid - 1] == target) {
                binarySearch(low, mid - 1, ans, nums, target);
            }
        } else if (nums[mid] > target) {
            binarySearch(low, mid - 1, ans, nums, target);
        } else {
            binarySearch(mid + 1, high, ans, nums, target);
        }
    }
}
