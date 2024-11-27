package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree">Problem link (LC-208)</a>
 */
public class ImplementTrie {
    /**
     * Time complexity: <br>
     * Insert = O(N) <br>
     * Search = O(N) <br>
     * Is Prefix  = O(N) <br>
     * where N is length of string
     */
    private static class Trie {
        TrieNode node;

        private static class TrieNode {
            Map<Character, TrieNode> charToTrieNode;
            boolean isPresent; // Set to true for the last character of the inserted string

            public TrieNode() {
                charToTrieNode = new HashMap<>();
                isPresent = false;
            }
        }

        public Trie() {
            this.node = new TrieNode();
        }

        public void insert(String word) {
            int i, len = word.length();
            TrieNode trieNode = node;
            for (i = 0; i < len; i++) {
                char ch = word.charAt(i);
                TrieNode newNode = new TrieNode();
                if (!trieNode.charToTrieNode.containsKey(ch)) {
                    trieNode.charToTrieNode.put(ch, newNode);
                } else {
                    newNode = trieNode.charToTrieNode.get(ch);
                }
                // This now becomes the new TrieNode
                trieNode = newNode;
            }
            trieNode.isPresent = true;
        }

        public boolean search(String word) {
            int i, n = word.length();
            TrieNode trieNode = node;
            for (i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (!trieNode.charToTrieNode.containsKey(ch)) {
                    return false;
                }
                trieNode = trieNode.charToTrieNode.get(ch);
            }
            return trieNode.isPresent;
        }


        public boolean startsWith(String prefix) {
            int i, n = prefix.length();
            TrieNode trieNode = node;
            for (i = 0; i < n; i++) {
                char ch = prefix.charAt(i);
                if (!trieNode.charToTrieNode.containsKey(ch)) {
                    return false;
                }
                trieNode = trieNode.charToTrieNode.get(ch);
            }
            return true;
        }
    }
}
