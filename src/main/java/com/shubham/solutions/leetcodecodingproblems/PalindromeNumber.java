package com.shubham.solutions.leetcodecodingproblems;


/**
 * <a href="https://leetcode.com/problems/palindrome-number">Problem link (LC-9)</a>
 */
public class PalindromeNumber {

    /**
     * Time complexity = O(1) <br>
     * Space complexity = O(1) <br>
     */
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int original = x;
        int numDigits = String.valueOf(x).length();
        int index = 1;
        while (x > 0) {
            int digit = x % 10;
            reverse += (int) (digit * Math.pow(10, numDigits - index));
            index++;
            x = x / 10;
        }
        return reverse == original;
    }
}
