package com.shubham.solutions.leetcodecodingproblems.segmentTree;

/**
 * <a href="https://www.geeksforgeeks.org/problems/range-minimum-query/1">Link</a>
 */
public class RangeMinimumQuery {

    static int segment[];

    public static int[] constructST(int arr[], int n) {
        segment = new int[4 * n];
        createSegmentTree(segment, arr, 0, n - 1, 0);
        return segment;
    }

    private static void createSegmentTree(int[] segment, int[] arr, int low, int high, int index) {
        int mid = (low + high) / 2;
        if (low == high) {
            // base case
            segment[index] = arr[low];
            return;
        }
        // traverse left
        createSegmentTree(segment, arr, low, mid, 2 * index + 1);
        // traverse right
        createSegmentTree(segment, arr, mid + 1, high, 2 * index + 2);
        //backtrack
        segment[index] = Math.min(segment[2 * index + 1], segment[2 * index + 2]);
    }


    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int[] st, int n, int l, int r) {
        return find(st, l, r, 0, n - 1, 0);
    }

    private static int find(int[] segment, int l, int r, int low, int high, int index) {
        if (low >= l && high <= r) {
            // The node lies in the range [l,r]
            // example: low,high=[4,6] --  l,r=[3,7]
            return segment[index];
        } else if (high < l || low > r) {
            // out of bounds
            return Integer.MAX_VALUE;
        } else {
            // Node overlaps with [l,r]
            // example: low,high=[2,6] --  l,r=[3,7]
            int mid = (low + high) / 2;
            return Math.min(find(segment, l, r, low, mid, 2 * index + 1), find(segment, l, r, mid + 1, high, 2 * index + 2));
        }
    }
}
