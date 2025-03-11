package com.shubham.solutions.leetcodecodingproblems.segmentTree;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-mutable">Link</a>
 */
public class RangeSumQueryMutable {

    static class NumArray {
        int[] segment;
        int len;

        public NumArray(int[] nums) {
            len = nums.length;
            segment = new int[4 * len];
            createSegmentTree(nums, 0, 0, len - 1);
        }

        private void createSegmentTree(int[] nums, int index, int low, int high) {
            if (low == high) {
                segment[index] = nums[low];
                return;
            }
            int mid = (low + high) / 2;
            createSegmentTree(nums, 2 * index + 1, low, mid);
            createSegmentTree(nums, 2 * index + 2, mid + 1, high);
            segment[index] = segment[2 * index + 1] + segment[2 * index + 2];
        }

        public void update(int index, int val) {
            updateSum(0, len - 1, 0, index, val);
        }

        private void updateSum(int low, int high, int index, int indexToUpdate,
                               int val) {
            if (low == high) {
                segment[index] = val;
                return;
            }
            int mid = (low + high) / 2;
            if (indexToUpdate <= mid) {
                updateSum(low, mid, 2 * index + 1, indexToUpdate, val);
            } else {
                updateSum(mid + 1, high, 2 * index + 2, indexToUpdate, val);
            }
            segment[index] = segment[2 * index + 1] + segment[2 * index + 2];
        }

        public int sumRange(int left, int right) {
            return findSum(0, len - 1, left, right, 0);
        }

        int findSum(int low, int high, int l, int r, int index) {
            if (low >= l && high <= r) {
                return segment[index];
            }
            if (r < low || l > high) {
                return 0;
            }
            int mid = (low + high) / 2;
            int left = findSum(low, mid, l, r, 2 * index + 1);
            int right = findSum(mid + 1, high, l, r, 2 * index + 2);
            return left + right;
        }
    }
}
