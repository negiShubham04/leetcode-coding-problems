package com.shubham.solutions.leetcodecodingproblems;

import java.util.LinkedList;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/combination-sum">Problem link (LC-39)</a>
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return findCombinationSum(candidates, 0, target, new LinkedList<>());
    }

    private List<List<Integer>> findCombinationSum(int[] candidates, int i, int target, List<Integer> ans) {
        List<List<Integer>> finalAns = new LinkedList<>();
        if (i >= candidates.length || target < 0) {
            return finalAns;
        }
        if (target == 0) {
            finalAns.add(new LinkedList<>(ans));
            return finalAns;
        }
        // pick
        ans.add(candidates[i]);
        List<List<Integer>> combinationSum = findCombinationSum(candidates, i,
                target - candidates[i], ans);
        ans.remove(ans.size() - 1);
        // not pick
        List<List<Integer>> combinationSum2 = findCombinationSum(candidates,
                i + 1, target, ans);
        combinationSum.addAll(combinationSum2);
        return combinationSum;
    }
}
