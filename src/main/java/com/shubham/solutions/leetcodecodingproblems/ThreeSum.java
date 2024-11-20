package com.shubham.solutions.leetcodecodingproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/3sum">Problem link (LC-15)</a>
 */
public class ThreeSum {

    /**
     * Time complexity = O(N * N) <br>
     * Space complexity = O(1) excluding the returned data set <br>
     * Approach used = Two pointers.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int i, n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (i = 0; i < n; i++) {
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return ans.stream().toList();
    }
}
