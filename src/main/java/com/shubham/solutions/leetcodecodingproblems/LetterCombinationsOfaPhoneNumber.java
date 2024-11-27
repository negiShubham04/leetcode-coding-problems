package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">Problem link (LC-17)</a>
 */
public class LetterCombinationsOfaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        return findLetterCombinations(digits, 0);
    }
    private List<String> findLetterCombinations(String digits, int i) {
        if (i >= digits.length()) return List.of();
        List<String> nextCombination = findLetterCombinations(digits, i + 1);
        List<Character> currentCombination = map.get(digits.charAt(i) - '0');
        List<String> ans = new LinkedList<>();
        if (nextCombination.isEmpty()) {
            for (Character ch : currentCombination) {
                ans.add(String.valueOf(ch));
            }
        } else {
            for (Character ch : currentCombination) {
                for (String str : nextCombination) {
                    ans.add(ch + str);
                }
            }
        }
        return ans;
    }
    private static final Map<Integer, List<Character>> map = Map.of(2, List.of('a', 'b', 'c'),
            3, List.of('d', 'e', 'f'), 4, List.of('g', 'h', 'i'), 5, List.of('j', 'k', 'l'), 6, List.of('m', 'n', 'o'),
            7, List.of('p', 'q', 'r', 's'), 8, List.of('t', 'u', 'v'), 9, List.of('w', 'x', 'y', 'z'));
}
