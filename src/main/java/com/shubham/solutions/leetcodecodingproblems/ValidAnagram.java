package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/valid-anagram">Problem link (LC-242)</a>
 */
public class ValidAnagram {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)
     * Approach used = Hashing
     */
    public boolean isAnagram(String s, String t) {
        int[] freqT = new int[26];
        int[] freqS = new int[26];
        int i;
        for (i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - '0']++;
        }
        for (i = 0; i < t.length(); i++) {
            freqT[t.charAt(i) - '0']++;
        }
        for (i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i]) return false;
        }
        return true;
    }
}
