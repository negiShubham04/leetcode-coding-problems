package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/gas-station">Problem link (LC-134)</a>
 */
public class GasStation {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach: greedy
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) return -1; // no solution is possible
        // example: gas [1,1,1]
        //          cost [2,2,2]
        int sum = 0;
        int start = 0;
        int i, len = cost.length;
        for (i = 0; i < len; i++) {
            sum += (gas[i] - cost[i]);
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        // there exists a solution definitely because the problem states that
        return start;
    }

    private int sum(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }
}
