package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/find-and-replace-in-string">Link</a>
 */
public class FindAndReplaceInString {


    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> stringIndexToIndices = new HashMap<>();
        int index;
        for (index = 0; index < indices.length; index++) {
            if (equals(s, indices[index], indices[index] + sources[index].length() - 1,
                sources[index])) {
                stringIndexToIndices.put(indices[index], index);
            }
        }
        int i = 0, n = s.length();
        String ans = "";
        while (i < n) {
            if (stringIndexToIndices.containsKey(i)) {
                ans += targets[stringIndexToIndices.get(i)];
                i += sources[stringIndexToIndices.get(i)].length();
            } else {
                ans += s.charAt(i++);
            }
        }
        return ans;
    }

    private boolean equals(String s, int start, int end, String target) {
        if (start < 0 || end >= s.length()) {
            return false;
        }
        return s.substring(start, end + 1).equals(target);
    }
}
