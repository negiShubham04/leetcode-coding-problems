package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring">Problem link (LC-76)</a>
 */
public class MinimumWindowSubstring {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public String minWindow(String s, String t) {
        String ans = "";
        int[] minLength = new int[]{Integer.MAX_VALUE};
        Map<Character, Integer> target = new HashMap<>();
        int i;
        for (i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> currentMap = new HashMap<>();
        i = 0;
        int j = 0;
        int distinctCharCount = 0;
        while (j < s.length()) {
            char currentChar = s.charAt(j);
            if (!target.containsKey(currentChar)) {
                j++;
                continue;
            }
            if (currentMap.containsKey(currentChar)) {
                if (currentMap.get(currentChar) < target.get(currentChar) && (currentMap.get(currentChar) + 1 >= target.get(
                        currentChar))) {
                    // If previously the character frequency is less than required but after this character it becomes greater or equal
                    // Example: [A - 2]  Target:[A - 3]
                    distinctCharCount++;
                }
                currentMap.put(currentChar, currentMap.get(currentChar) + 1);
            } else {
                currentMap.put(currentChar, 1);
                if (currentMap.get(currentChar) >= target.get(currentChar)) {
                    distinctCharCount++;
                }
            }
            if (distinctCharCount == target.size()) {
                ans = getStringIfTargetAchieved(distinctCharCount, target, s, minLength, i, j, ans);
                while (i <= j && distinctCharCount == target.size()) {
                    Integer freq = currentMap.get(s.charAt(i));
                    // We care only if the character is included in target
                    // string = "DDABCC" , target = "ABC"
                    // i = 0, j = 5
                    if (freq != null && target.containsKey(s.charAt(i))) {
                        if (freq > target.get(s.charAt(i))) {
                            // [A-3], target: [A - 2]
                            // We have more than required, so we shouldn't reduce the char count
                            freq--;
                        } else if (freq.intValue() == target.get(s.charAt(i))) {
                            freq--;
                            // [A-1], target: [A - 2]
                            // We had what is required, so we should reduce the char count
                            distinctCharCount--;
                        }
                        if (freq <= 0) {
                            currentMap.remove(s.charAt(i));
                        } else {
                            currentMap.put(s.charAt(i), freq);
                        }
                    }
                    i++;
                    ans = getStringIfTargetAchieved(distinctCharCount, target, s, minLength, i, j, ans);
                }
            }
            j++;
        }
        return ans;
    }

    private String getStringIfTargetAchieved(int distinctCharCount, Map<Character, Integer> target, String s, int[] minLength, int i, int j, String ans) {
        if (distinctCharCount == target.size()) {
            String str = s.substring(i, j + 1);
            if (str.length() < minLength[0]) {
                minLength[0] = str.length();
                return str;
            }
        }
        return ans;
    }
}
