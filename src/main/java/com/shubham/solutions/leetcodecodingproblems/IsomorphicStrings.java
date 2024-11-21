package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/isomorphic-strings">Problem link (LC-205)</a>
 */
public class IsomorphicStrings {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)
     * Approach used = Hashing
     */
    public boolean isIsomorphic(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) return false;
        int i;
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (i = 0; i < lenS; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sToT.containsKey(sChar) && sToT.get(sChar) != tChar) {
                return false;
            }
            sToT.put(sChar, tChar);
            if (tToS.containsKey(tChar) && tToS.get(tChar) != sChar) {
                return false;
            }
            tToS.put(tChar, sChar);
        }
        return true;
    }
}
