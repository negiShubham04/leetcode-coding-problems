package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string">Problem link (LC-151)</a>
 */
public class ReverseWordsInAString {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     * Approach used = String operation
     */
    public String reverseWords(String s) {
        int n = s.length();
        int i = n - 1;
        String ans = "";
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i >= 0 && s.charAt(i) != ' ') {
                String text = "";
                while (i >= 0 && s.charAt(i) != ' ') {
                    text = s.charAt(i) + text;
                    i--;
                }
                if (!ans.isEmpty()) {
                    ans = ans + " " + text;
                } else {
                    ans = text;
                }
            }
        }
        return ans;
    }
}
