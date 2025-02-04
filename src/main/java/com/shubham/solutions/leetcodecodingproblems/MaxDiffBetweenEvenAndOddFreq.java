package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/">LC-3442</a>
 */
public class MaxDiffBetweenEvenAndOddFreq {
    public int maxDifference(String s) {
        int len = s.length();
        int max = Integer.MIN_VALUE;
        int[] charArr = new int[26];
        int i, j;
        for (i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            charArr[index]++;
        }
        for (i = 0; i < 26; i++) {
            for (j = 0; j < 26; j++) {
                if (i != j & charArr[i] != 0 && charArr[j] != 0) {
                    if (isOppositeParity(charArr[i], charArr[j])) {
                        max = Math.max(max, diff(charArr[i], charArr[j]));
                    }
                }
            }
        }
        return max;
    }

    private int diff(int x, int y) {
        if (x % 2 == 0) {
            return y - x;
        }
        return x - y;
    }

    private boolean isOppositeParity(int x, int y) {
        return (x % 2 == 0 && y % 2 != 0) || (x % 2 != 0 && y % 2 == 0);
    }
}
