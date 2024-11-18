package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/is-subsequence">Problem link (LC-392)</a>
 */
public class IsSubsequence {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach used = Two pointers
     */
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS == 0) return true;
        if (lenT == 0) return false;
        int i = 0, j = 0;
        while (i < lenS && j < lenT) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == lenS;
    }
}
