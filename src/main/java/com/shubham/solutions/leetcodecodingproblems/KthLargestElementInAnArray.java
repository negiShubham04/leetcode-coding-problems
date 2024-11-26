package com.shubham.solutions.leetcodecodingproblems;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array">Problem link (LC-215)</a>
 */
public class KthLargestElementInAnArray {

    /**
     * Time complexity = O(N * LogN) <br>
     * Space complexity = O(K) <br>
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i;
        for (i = 0; i < len; i++) {
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
                minHeap.poll();
            }
        }

        if (!minHeap.isEmpty()) return minHeap.poll();
        return -1;
    }
}
