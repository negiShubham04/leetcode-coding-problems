package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/h-index">Problem link (LC-274)</a>
 */
public class HIndex {

    /**
     * TC = O(N Log N)<br>
     * SC = O(1)<br>
     * Binary search
     */
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length;
        int mid;
        int ans = Integer.MIN_VALUE;
        while (low <= high) {
            mid = (low + high) / 2;
            if (isHIndex(mid, citations)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isHIndex(int value, int[] citations) {
        int ans = 0;
        for (int citation : citations) {
            if (citation >= value) {
                ans++;
            }
        }
        return ans >= value;
    }
}
