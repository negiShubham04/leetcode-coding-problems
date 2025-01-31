package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-break">Problem link (LC-139)</a>
 */
public class WordBreak {
    /**
     * TC = O(N*N)<br>
     * SC = O(N)
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        int i, j, len = s.length();
        boolean[] cache = new boolean[len + 1];
        cache[len] = true;
        for (i = len - 1; i >= 0; i--) {
            String str = "";
            for (j = i; j < len; j++) {
                str += s.charAt(j);
                if (dictionary.contains(str)) {
                    cache[i] = cache[j + 1];
                    if (cache[i]) {
                        // failing case-> dictionary: [car, carf, fast], s :  "carfast"
                        // initially 0th index will store true
                        // but then false will override if this 'if' condition is not present
                        break;
                    }
                }
            }
        }
        return cache[0];
    }
}
