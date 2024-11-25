package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">Problem link (LC-121)</a>
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)<br>
     * Approach used = Array iteration and greedy.
     */
    public int maxProfit(int[] prices) {
        int i, len = prices.length;
        int maxProfit = 0;
        int minElementSoFar = Integer.MAX_VALUE;
        for (i = 0; i < len; i++) {
            if (prices[i] < minElementSoFar) {
                minElementSoFar = Math.min(minElementSoFar, prices[i]);
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minElementSoFar);
            }
        }
        return maxProfit;
    }

}
