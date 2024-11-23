package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/summary-ranges">Problem link (LC-228)</a>
 */
public class SummaryRanges {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)[output] <br>
     * Approach used = Iteration.
     */
    public List<String> summaryRanges(int[] nums) {
        int i = 0, len = nums.length;
        List<String> ans = new ArrayList<>();
        String str;
        while (i < len) {
            str = String.valueOf(nums[i]);
            boolean isConsecutiveCharFound = false;
            while (i + 1 < len && nums[i] + 1 == nums[i + 1]) {
                i++;
                isConsecutiveCharFound = true;
            }
            if (isConsecutiveCharFound) {
                str = str + "->" + nums[i];
            }
            ans.add(str);
            i++;
        }
        return ans;
    }
}
