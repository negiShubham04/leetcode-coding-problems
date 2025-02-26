package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">Link</a>
 */
public class MinimumInsertionStepsToMakeStringPalindrome {

    /**
     * Tabulation approach
     */

    int minInsertions(String s) {
        int len = s.length();
        if (len == 1) return 0;
        int[][] dp = new int[len + 1][len + 1];
        int i, j;
        for (i = 0; i < len + 1; i++) {
            dp[i][i] = 0;
        }
        for (i = len - 1; i >= 0; i--) {
            for (j = i; j < len; j++) {
                char first = s.charAt(i);
                char last = s.charAt(j);
                if (first == last) {
                    dp[i][j] = (j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;

                } else {
                    int f1 = (j - 1 >= 0 && dp[i][j - 1] != Integer.MAX_VALUE ? 1 + dp[i][j - 1] : Integer.MAX_VALUE);
                    int f2 = (dp[i + 1][j] != Integer.MAX_VALUE ? 1 + dp[i + 1][j] : Integer.MAX_VALUE);
                    dp[i][j] = Math.min(f1, f2);
                }
            }
        }
        return dp[0][len - 1];
    }

    /**
     * Memoized approach
     */
    int findMinInsert(String s, int low, int high, Map<String, Integer> cache) {
        if (low >= high) {
            return 0;
        }
        String key = low + "-" + high;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        char first = s.charAt(low);
        char last = s.charAt(high);
        int ans;
        if (first == last) {
            ans = findMinInsert(s, low + 1, high - 1, cache);
        } else {
            int f1 = findMinInsert(s, low, high - 1, cache);
            f1 = (f1 != Integer.MAX_VALUE ? f1 + 1 : f1);
            int f2 = findMinInsert(s, low + 1, high, cache);
            f2 = (f2 != Integer.MAX_VALUE ? f2 + 1 : f2);
            ans = Math.min(f1, f2);
        }
        cache.put(key, ans);
        return ans;

    }
}
