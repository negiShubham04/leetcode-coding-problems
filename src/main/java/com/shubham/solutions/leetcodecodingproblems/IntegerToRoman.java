package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">Problem link (LC-12)</a>
 */
public class IntegerToRoman {
    final static Map<Integer, String> integerToRoman = new HashMap<>(Map.of(
            50, "L", 100, "C", 500, "D", 1000, "M",
            4, "IV", 9, "IX", 40, "XL", 90,
            "XC", 400, "CD", 900, "CM"));
    List<Integer> numbers = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    static {
        integerToRoman.put(1, "I");
        integerToRoman.put(5, "V");
        integerToRoman.put(10, "X");
    }

    /**
     * TC = O(N)  <br>
     * SC = O(1)  <br>
     */
    public String intToRoman(int num) {
        return convertToRoman(num);
    }

    private String convertToRoman(int num) {
        if (integerToRoman.containsKey(num)) return integerToRoman.get(num);
        if (num <= 0) return "";
        for (int val : numbers) {
            if (num > val) {
                num = num - val;
                return integerToRoman.get(val) + convertToRoman(num);
            }
        }
        return "";
    }
}
