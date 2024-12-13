package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/coin-change/">Problem link (LC-322)</a>
 */
public class CoinChange {

    /**
     * TC = O(N*M)<br>
     * SC = O(N*M)<br>
     * Approach = DP
     */
    public int coinChange(int[] coins, int amount) {
        int row = coins.length;
        int col = amount + 1;
        int[][] coinChange = new int[row][col];
        int i;
        for (i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) continue;
                int take = (j - coins[i] >= 0 && j - coins[i] < coinChange[i].length) ?
                        coinChange[i][j - coins[i]] : Integer.MAX_VALUE;
                if (take != Integer.MAX_VALUE) {
                    take++;
                }
                int notTake = i - 1 < 0 ? Integer.MAX_VALUE : coinChange[i - 1][j];
                coinChange[i][j] = Math.min(take, notTake);
            }
        }
        int minCoins = coinChange[row - 1][col - 1];
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
