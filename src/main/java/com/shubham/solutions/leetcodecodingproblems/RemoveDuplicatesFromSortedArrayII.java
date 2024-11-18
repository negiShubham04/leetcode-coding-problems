package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii">Problem link (LC-80)</a>
 */
public class RemoveDuplicatesFromSortedArrayII {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach used = two pointers
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        if (i + 1 < n && nums[i] == nums[i + 1]) {
            i++;
            j++;
            // for cases where element at first index repeats.
        }
        while (j < n) {
            if (j + 1 < n && nums[j] != nums[j + 1] && i + 1 < n) {
                nums[i + 1] = nums[j + 1];
                if (j + 2 < n && i + 2 < n && nums[j + 1] == nums[j + 2]) {
                    nums[i + 2] = nums[j + 2];
                    i += 2;
                } else {
                    i++;
                }
            }
            j++;
        }
        return i + 1;
    }
}
