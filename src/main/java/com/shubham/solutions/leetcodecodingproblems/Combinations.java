package com.shubham.solutions.leetcodecodingproblems;


import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combinations">Problem link (LC-77)</a>
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        return funCombine(n, k, 1);
    }

    private List<List<Integer>> funCombine(int n, int k, int startFrom) {
        List<Integer> ans;
        List<List<Integer>> finalAns = new LinkedList<>();
        if (k <= 0) {
            return finalAns;
        }
        if (startFrom > n) {
            return finalAns;
        }
        if (k == 1) {
            for (int i = startFrom; i <= n; i++) {
                ans = new LinkedList<>();
                ans.add(i);
                finalAns.add(ans);
            }
            return finalAns;
        }
        List<List<Integer>> next = funCombine(n, k - 1, startFrom + 1);
        for (int i = startFrom; i <= n; i++) {
            for (List<Integer> l : next) {
                if (!l.isEmpty() && i < l.get(0)) {
                    ans = new LinkedList<>();
                    ans.add(i);
                    ans.addAll(l);
                    finalAns.add(ans);
                }
            }
        }
        return finalAns;
    }
}
