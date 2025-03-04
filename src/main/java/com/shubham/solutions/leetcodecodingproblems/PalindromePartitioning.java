package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/description/">Palindrome partitioning</a>
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        findPartition(s, 0, ans, new LinkedList<>(), "");
        return ans;
    }

    private void findPartition(String s, int i, List<List<String>> ans, List<String> list, String curr) {
        int n = s.length();
        if (i >= n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        String str = curr;
        for (int j = i; j < n; j++) {
            str += s.charAt(j);
            if (isPalidrome(str)) {
                list.add(str);
                findPartition(s, j + 1, ans, list, "");
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalidrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
