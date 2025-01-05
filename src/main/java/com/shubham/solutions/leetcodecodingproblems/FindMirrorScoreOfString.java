package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


/**
 * <a href="https://leetcode.com/problems/find-mirror-score-of-a-string/">Problem link (LC-3412)</a>
 */
public class FindMirrorScoreOfString {

    public long calculateScore(String s) {
        int len = s.length();
        long ans = 0;
        char[] characterMapping = new char[26];
        for (char ch = 'a'; ch <= 'z'; ch++) {
            characterMapping[ch - 'a'] = ch;
        }
        Map<Character, TreeSet<Integer>> freq = new HashMap<>();
        int i;
        for (i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int index = 'z' - ch;
            char mirrorCh = characterMapping[index];
            if (freq.containsKey(mirrorCh)) {
                TreeSet<Integer> treeSet = freq.get(mirrorCh);
                Integer indexOfMirrorCharacter = treeSet.floor(i);
                if (indexOfMirrorCharacter != null && indexOfMirrorCharacter < i) {
                    ans += (Math.abs(indexOfMirrorCharacter - i));
                    treeSet.remove(indexOfMirrorCharacter);
                } else {
                    freq.computeIfAbsent(ch, x -> new TreeSet<>()).add(i);
                }
            } else {
                freq.computeIfAbsent(ch, x -> new TreeSet<>()).add(i);
            }
        }
        return ans;
    }
}
