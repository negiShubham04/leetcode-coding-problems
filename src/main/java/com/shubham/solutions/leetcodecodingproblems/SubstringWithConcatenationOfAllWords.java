package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    //todo: Fix me. Giving TLE for one case
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int windowSize = wordLen * words.length;
        List<Integer> ans = new LinkedList<>();
        Map<String, Integer> original = new HashMap<>();
        for (String word : words) {
            original.put(word, original.getOrDefault(word, 0) + 1);
        }
        int i = 0, j = 0;
        LinkedList<Character> str = new LinkedList<>();
        while (j < s.length()) {
            while (j < s.length() && j - i + 1 < windowSize) {
                str.addLast(s.charAt(j));
                j++;
            }
            if (j < s.length() && j - i + 1 == windowSize) {
                str.addLast(s.charAt(j));
            }
            if (contains(original, str, wordLen)) {
                ans.add(i);
            }
            if (!str.isEmpty())
                str.removeFirst();
            i++;
            j++;
        }
        return ans;
    }

    private boolean contains(Map<String, Integer> freq, LinkedList<Character> str, int wordLen) {
        int i, n = str.size();
        Map<String, Integer> used = new HashMap<>();
        for (i = 0; i < n; i += wordLen) {
            String s = "";
            for (int j = i; j < i + wordLen && j < n; j++) {
                s += str.get(j);
            }
            if (freq.containsKey(s)) {
                int val = freq.get(s);
                val--;
                used.put(s, used.getOrDefault(s, 0) + 1);
                if (val <= 0) {
                    freq.remove(s);
                } else {
                    freq.put(s, val);
                }
            } else {
                mergeAll(freq, used);
                return false;
            }
        }
        boolean value = freq.isEmpty();
        mergeAll(freq, used);
        return value;
    }

    private void mergeAll(Map<String, Integer> freq, Map<String, Integer> used) {
        if (used.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Integer> entry : used.entrySet()) {
            if (freq.containsKey(entry.getKey())) {
                freq.put(entry.getKey(), freq.get(entry.getKey()) + entry.getValue());
            } else {
                freq.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
