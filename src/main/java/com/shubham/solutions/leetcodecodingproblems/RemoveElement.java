package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/remove-element">Problem link (LC-27)</a>
 */
public class RemoveElement {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)
     * Approach used = Two pointers
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int pointerVal = 0;
        int index = 0;
        while (pointerVal < n && index < n) {
            while (pointerVal < n && nums[pointerVal] != val) {
                pointerVal++;
            }
            if (pointerVal < n && nums[pointerVal] == val) {
                index = pointerVal + 1;
                while (index < n && nums[index] == val) {
                    index++;
                }
                if (index < n && nums[index] != val) {
                    swap(nums, index, pointerVal);
                    pointerVal++;
                }
            }
        }
        return pointerVal;
    }

    private void swap(int[] nums, int index, int pointerVal) {
        int temp = nums[index];
        nums[index] = nums[pointerVal];
        nums[pointerVal] = temp;
    }
}
