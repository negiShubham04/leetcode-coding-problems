package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/corporate-flight-bookings/description/">Problem link (LC-1109)</a>
 */
public class CorporateFlightBookings {

    /**
     * Its a line sweep problem
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int i;
        for (i = 0; i < bookings.length; i++) {
            int start = bookings[i][0];
            int end = bookings[i][1];
            int cost = bookings[i][2];
            // The cost is included from start till end but after end+1. It should be excluded.
            ans[start - 1] += cost;
            if (end < n) {
                ans[end] -= cost;
            }
        }
        for (i = 1; i < n; i++) {
            // Prefix sum
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
