package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome">Problem link (LC-125)</a>
 */
public class ValidPalindrome {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach used = Two pointers (start and end)
     */
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        int len = s.length();
        while (start < end) {
            while (start < len && !isAlphanumeric(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !isAlphanumeric(s.charAt(end))) {
                end--;
            }
            if (start < len && end >= 0) {
                char startCh = String.valueOf(s.charAt(start)).toLowerCase().charAt(0);
                char endCh = String.valueOf(s.charAt(end)).toLowerCase().charAt(0);
                if (startCh == endCh) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
