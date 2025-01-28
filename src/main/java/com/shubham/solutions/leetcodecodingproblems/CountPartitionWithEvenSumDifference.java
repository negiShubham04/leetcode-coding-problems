package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/count-partitions-with-even-sum-difference">LC-3432</a>
 */
public class CountPartitionWithEvenSumDifference {

    public int countPartitions(int[] nums) {
        int count = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            leftSum += num;
            rightSum -= num;
            if ((leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
