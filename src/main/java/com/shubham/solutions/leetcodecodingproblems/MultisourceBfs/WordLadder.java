package com.shubham.solutions.leetcodecodingproblems.MultisourceBfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-ladder/description/"> Word ladder</a>
 */
public class WordLadder {
    public int ladderLength(String begin, String end, List<String> words) {
        int i, j, n = words.size();
        Map<String, List<String>> adj = new HashMap<>();
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (canConvert(words.get(i), words.get(j))) {
                    // prepare adjacency list from word i to word j.
                    adj.computeIfAbsent(words.get(i), x -> new LinkedList<>()).add(words.get(j));
                    adj.computeIfAbsent(words.get(j), x -> new LinkedList<>()).add(words.get(i));
                }
            }
        }
        for (String word : words) {
            if (canConvert(word, begin)) {
                adj.computeIfAbsent(word, x -> new LinkedList<>()).add(begin);
                adj.computeIfAbsent(begin, x -> new LinkedList<>()).add(word);
            }
        }
        if (adj.get(begin) == null) return 0;
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{begin, 1});
        Set<String> vis = new HashSet<>();
        while (!queue.isEmpty()) {
            Object[] obj = queue.poll();
            String word = (String) obj[0];
            int value = (int) obj[1];
            vis.add(word);
            if (word.equals(end)) return value;
            for (String child : adj.getOrDefault(word, List.of())) {
                if (!vis.contains(child)) {
                    queue.add(new Object[]{child, value + 1});
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String w1, String w2) {
        if (w1.length() != w2.length()) return false;
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (count != 0) return false;
                count++;
            }
        }
        return count == 1;
    }
}
