package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix">Problem link (LC-14)</a>
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int i = 0;
        String ans = "";
        int j = 0;
        while (true) {
            if (j >= strs[0].length()) return ans;
            char ch = strs[0].charAt(j);
            for (int k = i + 1; k < n; k++) {
                if (j >= strs[k].length() || ch != strs[k].charAt(j)) {
                    return ans;
                }
            }
            ans += ch;
            j++;
        }
    }
}
