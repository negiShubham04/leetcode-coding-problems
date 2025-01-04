package com.shubham.solutions.leetcodecodingproblems;
/**
 * <a href="https://leetcode.com/problems/substring-matching-pattern/">Problem link (LC-3408)</a>
 */
public class SubstringMatchingPattern {

    public boolean hasMatch(String s, String p) {
        int i = p.indexOf("*");
        String firstHalf = p.substring(0, i);
        String secondHalf = p.substring(i + 1);
        int firstHalfIndex = s.indexOf(firstHalf);
        if (firstHalfIndex == -1) return false;
        int secondHalfIndex = s.lastIndexOf(secondHalf);
        return  (secondHalfIndex >= (firstHalfIndex + firstHalf.length()));
    }
}
