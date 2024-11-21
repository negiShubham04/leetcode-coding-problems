package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/word-patterne">Problem link (LC-290)</a>
 */
public class WordPattern {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)
     * Approach used = Hashing and string
     */
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> stringToChar = new HashMap<>();
        Map<Character, String> charToString = new HashMap<>();
        int i;
        String[] str = split(' ', s);
        if (str.length != pattern.length()) return false;
        int len = str.length;
        for (i = 0; i < len; i++) {
            char ch = pattern.charAt(i);
            if (charToString.containsKey(ch) && !charToString.get(ch).equals(str[i])) {
                return false;
            }
            charToString.put(ch, str[i]);

            if (stringToChar.containsKey(str[i]) && stringToChar.get(str[i]) != ch) {
                return false;
            }
            stringToChar.put(str[i], ch);
        }
        return true;
    }

    private String[] split(char pattern, String s) {
        List<String> list = new LinkedList<>();
        int i = 0, n = s.length();
        String str = "";
        while (i < n) {
            str = "";
            while (i < n && s.charAt(i) != pattern) {
                str += s.charAt(i);
                i++;
            }
            if (!str.isEmpty()) {
                list.add(str);
            }
            i++;
        }
        System.out.println(list);
        return list.toArray(value -> new String[0]);
    }
}
