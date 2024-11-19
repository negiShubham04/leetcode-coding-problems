package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word">Problem link (LC-58)</a>
 */
public class LengthOfLastWord {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     * Approach used = String operation
     */
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        String ans = "";
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i >= 0 && s.charAt(i) != ' ') {
            while (i >= 0 && s.charAt(i) != ' ') {
                ans = s.charAt(i) + ans;
                i--;
            }
            return ans.length();
        }
        return 0;
    }
}
