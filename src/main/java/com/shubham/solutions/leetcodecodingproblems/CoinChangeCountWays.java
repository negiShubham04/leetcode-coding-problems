package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://www.geeksforgeeks.org/problems/coin-change2448/1">Coin change </a>
 */
public class CoinChangeCountWays {

    public int count(int[] coins, int sum) {
        int n = coins.length;
        int[][] ans = new int[n + 1][sum + 1];
        int i, j;
        // Converted recursive to Bottom up (Tabulation)
        for (i = 0; i <= n; i++) {
            ans[i][0] = 1;
        }
        for (i = n - 1; i >= 0; i--) {
            for (j = 0; j <= sum; j++) {
                int take = j - coins[i] >= 0 ? ans[i][j - coins[i]] : 0;
                int notTake = i + 1 < (n + 1) ? ans[i + 1][j] : 0;
                ans[i][j] = take + notTake;
            }
        }
        return ans[0][sum];
        // return findCount(coins, sum , 0);
    }

    // Traditional recursive code
    int findCount(int[] coins, int sum, int i) {
        int n = coins.length;
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (i >= n) return 0;
        int take = findCount(coins, sum - coins[i], i);
        int notTake = findCount(coins, sum, i + 1);
        return take + notTake;
    }
}
