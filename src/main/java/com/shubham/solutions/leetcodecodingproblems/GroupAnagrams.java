package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/group-anagrams">Problem link (LC-49)</a>
 */
public class GroupAnagrams {

    /**
     * Time complexity = O(N * M LogM) where M is length of each string, N is size of array <br>
     * Space complexity = O(N)[output] <br>
     * Approach used = sorting and hashing
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int i;
        Map<String, List<String>> stringsBySortedKey = new HashMap<>();
        for (i = 0; i < n; i++) {
            String str = strs[i];
            String sortedStr = sort(str);
            stringsBySortedKey.computeIfAbsent(sortedStr, x -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(stringsBySortedKey.values());
    }

    private String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
