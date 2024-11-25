package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">Problem link (LC-122)</a>
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        Map<String, Integer> dp = new HashMap<>();
        return findMaxProfit(0, len, prices, true, dp);
    }

    private int findMaxProfit(int i, int len, int[] prices, boolean canBuy, Map<String, Integer> dp) {
        if (i >= len) return 0;
        String key = canBuy + "-" + i;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ans;
        if (canBuy) {
            ans = Math.max(findMaxProfit(i + 1, len, prices, false, dp) - prices[i]
                    , findMaxProfit(i + 1, len, prices, canBuy, dp));
        } else {
            ans = Math.max(findMaxProfit(i + 1, len, prices, true, dp) + prices[i]
                    , findMaxProfit(i + 1, len, prices, canBuy, dp));
        }
        dp.put(key, ans);
        return ans;
    }
}
