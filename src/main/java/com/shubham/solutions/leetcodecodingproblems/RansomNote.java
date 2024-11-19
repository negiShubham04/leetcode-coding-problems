package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/ransom-note">Problem link (LC-383)</a>
 */
public class RansomNote {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     * Approach used = Map usage
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> frequencyByCharacter = new HashMap<>();
        int i, n = magazine.length();
        for (i = 0; i < n; i++) {
            char ch = magazine.charAt(i);
            frequencyByCharacter.put(ch, frequencyByCharacter.getOrDefault(ch, 0) + 1);
        }
        System.out.println(frequencyByCharacter);
        n = ransomNote.length();
        for (i = 0; i < n; i++) {
            char ch = ransomNote.charAt(i);
            if (!frequencyByCharacter.containsKey(ch)) {
                return false;
            }
            int frequency = frequencyByCharacter.get(ch);
            frequency--;
            if (frequency == 0) {
                frequencyByCharacter.remove(ch);
            } else {
                frequencyByCharacter.put(ch, frequency);
            }
        }
        return true;
    }
}
