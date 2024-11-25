package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Problem link (LC-3)</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {


    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(26) <br>
     * Approach used = Sliding window
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0, j = 0;
        int longestLen = (len == 0 ? 0 : 1);
        Map<Character, Integer> uniqueChars = new HashMap<>();
        while (j < len) {
            char ch = s.charAt(j);
            if (!uniqueChars.containsKey(ch)) {
                uniqueChars.put(ch, 1);
                longestLen = Math.max(longestLen, uniqueChars.size());
            } else {
                uniqueChars.put(ch, uniqueChars.getOrDefault(ch, 0) + 1);
                while (i <= j && uniqueChars.containsKey(s.charAt(i)) && anyValueMoreThanOne(uniqueChars)) {
                    int value = uniqueChars.get(s.charAt(i));
                    value--;
                    if (value <= 0) {
                        uniqueChars.remove(s.charAt(i));
                    } else {
                        uniqueChars.put(s.charAt(i), value);
                    }
                    i++;
                }
                longestLen = Math.max(longestLen, uniqueChars.size());
            }
            j++;
        }
        return longestLen;
    }

    private boolean anyValueMoreThanOne(Map<Character, Integer> uniqueChars) {
        for (Integer value : uniqueChars.values()) {
            if (value > 1) return true;
        }
        return false;
    }
}
