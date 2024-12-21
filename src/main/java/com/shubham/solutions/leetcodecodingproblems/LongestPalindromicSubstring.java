package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">Problem link (LC-5)</a>
 */
public class LongestPalindromicSubstring {
    /**
     * TC = O(N*N) <br>
     * SC = O(1)  <br>
     */
    public String longestPalindrome(String s) {
        String ans = String.valueOf(s.charAt(0));
        int i, len = s.length();
        for (i = 0; i < len; i++) {
            // Taking 'i' as mid of ans, expand the range to left and right
            // case: abba, i = 1
            String currentAns = getPalindrome(s, i, i + 1);
            if (currentAns.length() > ans.length()) {
                ans = currentAns;
            }
            // case: abxba, i = 2
            currentAns = getPalindrome(s, i - 1, i + 1);
            if (currentAns.length() > ans.length()) {
                ans = currentAns;
            }
        }
        return ans;
    }

    private String getPalindrome(String s, int low, int high) {
        int len = s.length();
        int prevLow = -1;
        int prevHigh = -1;
        while (isValid(low, len) && isValid(high, len) && s.charAt(low) == s.charAt(high)) {
            prevLow = low;
            prevHigh = high;
            low--;
            high++;
        }
        if (prevLow != -1 && prevHigh != -1) {
            return s.substring(prevLow, prevHigh + 1);
        }
        return "";
    }

    private boolean isValid(int i, int len) {
        return i >= 0 && i < len;
    }
}
