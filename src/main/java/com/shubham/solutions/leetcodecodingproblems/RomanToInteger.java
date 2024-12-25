package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer">Problem link (LC-13)</a>
 */
public class RomanToInteger {
    Map<String, Integer> romanToInteger = new HashMap<>(Map.of(
            "L", 50, "C", 100, "D", 500, "M", 1000, "IV", 4, "IX", 9, "XL", 40, "XC", 90, "CD", 400, "CM", 900));

    /**
     * TC = O(N)  <br>
     * SC = O(1)  <br>
     */
    public int romanToInt(String s) {
        romanToInteger.put("I", 1);
        romanToInteger.put("V", 5);
        romanToInteger.put("X", 10);
        int i, n = s.length();
        int ans = 0;
        for (i = 0; i < n; i++) {
            String charStr = String.valueOf(s.charAt(i));
            if (i + 1 < n && romanToInteger.containsKey(charStr + s.charAt(i + 1))) {
                ans += romanToInteger.get(charStr + s.charAt(i + 1));
                i++;
            } else {
                ans += romanToInteger.get(charStr);
            }
        }
        return ans;
    }
}
