package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * <a href="https://leetcode.com/problems/permutations/">Problem link (LC-46)</a>
 */
public class Permutations {

    /**
     * Time complexity = O(N!) <br>
     * Space complexity = O(N!) <br>
     */
    public List<List<Integer>> permute(int[] nums) {
        return findPermutations(nums, new LinkedList<>());
    }

    private List<List<Integer>> findPermutations(int[] nums, List<Integer> ans) {
        List<List<Integer>> finalAns = new LinkedList<>();
        if (ans.size() == nums.length) {
            finalAns.add(new ArrayList<>(ans));
            return finalAns;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != Integer.MIN_VALUE) {
                int oldValue = nums[i];
                nums[i] = Integer.MIN_VALUE;
                ans.add(oldValue);
                finalAns.addAll(findPermutations(nums, ans));
                ans.remove(ans.size() - 1);
                nums[i] = oldValue;
            }
        }
        return finalAns;
    }
}
