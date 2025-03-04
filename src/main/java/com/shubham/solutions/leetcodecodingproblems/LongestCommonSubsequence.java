package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/"> Longest common subsequence</a>
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] ans = new int[n1][n2];
        int i, j;
        // Converted recursive code to Bottom up (Tabulation)
        for (i = 0; i < n1; i++) {
            for (j = 0; j < n2; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    ans[i][j] = 1 + (i - 1 >= 0 && j - 1 >= 0 ? ans[i - 1][j - 1] : 0);
                } else {
                    ans[i][j] = Math.max((i - 1 >= 0 ?
                            ans[i - 1][j] : 0), (j - 1 >= 0 ? ans[i][j - 1] : 0));
                }
            }
        }
        return ans[n1 - 1][n2 - 1];
    }

    // recursive code
    // findLCS(s1, s1.len-1, s2, s2.len-1)
    int findLCS(String s1, int l1, String s2, int l2) {
        if (l1 < 0 || l2 < 0) return 0;
        if (s1.charAt(l1) == s2.charAt(l2)) {
            return 1 + findLCS(s1, l1 - 1, s2, l2 - 1);
        }
        return Math.max(findLCS(s1, l1 - 1, s2, l2), findLCS(s1, l1, s2, l2 - 1));
    }
}
