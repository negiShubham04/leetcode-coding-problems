package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">LC-211</a>
 */
public class DesignAddAndSearchWordsDataStructure {

    static class WordDictionary {
        Trie trie;

        private static class Trie {
            Map<Character, Trie> map;
            // The boolean is very important. Consider cases like ca, car, cart
            // This will track whether the word exist or not
            boolean isWordExist = false;

        }

        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            Trie current = trie;
            for (int i = 0; i < word.length(); i++) {
                if (current.map == null) {
                    current.map = new HashMap<>();
                }
                char character = word.charAt(i);
                if (!current.map.containsKey(character)) {
                    current.map.put(character, new Trie());
                }
                current = current.map.get(character);
            }
            current.isWordExist = true;
        }

        public boolean search(String word) {
            Trie current = trie;
            return search(word, 0, current);
        }

        private boolean search(String word, int i, Trie current) {
            if (i >= word.length()) {
                return current.isWordExist;
            }
            while (i < word.length()) {
                char ch = word.charAt(i);
                if (ch == '.') {
                    if (current == null || current.map == null) return false;
                    for (Map.Entry<Character, Trie> entry : current.map.entrySet()) {
                        if (search(word, i + 1, entry.getValue())) {
                            return true;
                        }
                    }
                    return false;
                }
                if (current == null || current.map == null || current.map.get(word.charAt(i)) == null) return false;
                current = current.map.get(ch);
                i++;
            }
            return current.isWordExist;
        }
    }
}
