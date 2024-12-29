package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/sqrtx/">Problem link (LC-69)</a>
 */
public class SqrtX {

    /**
     * Time complexity = O(Log X) <br>
     * Space complexity = O(1) <br>
     */
    public int mySqrt(int x) {
        if (x == 0) return x;
        long low = 1, high = x;
        int ans = Integer.MIN_VALUE;
        while (low <= high) {
            long mid = (low + high) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                low = (int) mid + 1;
                ans = Math.max(ans, (int) mid);
            } else {
                high = (int) mid - 1;
            }
        }
        return ans;
    }
}
