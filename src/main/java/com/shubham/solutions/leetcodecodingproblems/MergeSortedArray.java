package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array">Problem link(88)</a>
 */
public class MergeSortedArray {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N).
     * Approach used = Two pointers
     */
    public void merge(int[] nums1, int num1Len, int[] nums2, int n) {
        List<Integer> ans = new ArrayList<>();
        int num1Pointer = 0;
        int num2Pointer = 0;
        while (num2Pointer < n && num1Pointer < num1Len) {
            if (nums1[num1Pointer] != 0 && nums1[num1Pointer] <= nums2[num2Pointer]) {
                ans.add(nums1[num1Pointer++]);
            } else {
                ans.add(nums2[num2Pointer++]);
            }
        }
        while (num2Pointer < nums2.length) {
            ans.add(nums2[num2Pointer++]);
        }
        while (num1Pointer < num1Len) {
            ans.add(nums1[num1Pointer++]);
        }
        nums1 = new int[ans.size()];
        int i;
        for (i = 0; i < ans.size(); i++) {
            nums1[i] = ans.get(i);
        }
    }
}
