package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">Problem link (LC-26)</a>
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)
     * Approach used = Two pointers
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (i + 1 < n && j + 1 < n && nums[j] != nums[j + 1]) {
                nums[i + 1] = nums[j + 1];
                i++;
            }
            j++;
        }
        return i + 1;
    }
}
