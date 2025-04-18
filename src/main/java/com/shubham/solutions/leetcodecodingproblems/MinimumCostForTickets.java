package com.shubham.solutions.leetcodecodingproblems;

import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/description/">Problem link (LC-983)</a>
 */
public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int i, n = days.length;
        int[] table = new int[n];
        table[n - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (i = n - 2; i >= 0; i--) {
            int one = costs[0] + table[i + 1];
            int seven = costs[1];
            int j = i;
            for (j = i; j < n && days[j] <= days[i] + 6; j++) {
            }
            seven = j < n ? costs[1] + table[j] : seven;
            int thirty = costs[2];
            for (j = i; j < n && days[j] <= days[i] + 29; j++) {
            }
            thirty = j < n ? costs[2] + table[j] : thirty;
            int ans = Math.min(one, Math.min(seven, thirty));
            table[i] = ans;
            //  System.out.println(i+": "+table[i]);
        }
        return table[0];
    }

    /**
     * Recursive approach
     */
    private int findMin(int[] days, int[] costs, int i, Map<Integer, Integer> dp) {
        if (i >= days.length) {
            return 0;
        }
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        int one = costs[0] + findMin(days, costs, i + 1, dp);
        int seven = 0;
        int j = i, n = days.length;
        for (j = i; j < n && days[j] <= days[i] + 6; j++) {
        }
        seven = costs[1] + findMin(days, costs, j, dp);
        int thirty = 0;
        for (j = i; j < n && days[j] <= days[i] + 29; j++) {
        }
        thirty = costs[2] + findMin(days, costs, j, dp);
        int ans = Math.min(one, Math.min(seven, thirty));
        dp.put(i, ans);
        return ans;
    }

}
