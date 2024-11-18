package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">Problem link (LC-167)</a>
 */
public class TwoSum2InputArrayIsSorted {
    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach used = Two pointers
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        // default
        return new int[]{-1, -1};
    }
}
