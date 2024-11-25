package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;


/**
 * <a href="https://leetcode.com/problems/merge-intervalsi">Problem link (LC-56)</a>
 */
public class MergeIntervals {


    /**
     * Time complexity = O(N*LogN) <br>
     * Space complexity = O(N) [Output]<br>
     * Approach used = Merging
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new LinkedList<>();
        int len = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] start = new int[]{intervals[0][0], intervals[0][1]};
        if (len == 1) ans.add(start);
        else {
            int i;
            for (i = 1; i < len; i++) {
                List<Object> overlap = overlap(start, intervals[i]);
                if (overlap.size() == 2) {
                    int[] arr = (int[]) overlap.get(0);
                    start = arr;
                } else {
                    ans.add(start);
                    start = intervals[i];
                }
            }
        }
        // case:[[1,3][2,4]]
        if (ans.isEmpty() || ans.get(ans.size() - 1) != start)
            ans.add(start);
        return ans.toArray(value -> new int[0][]);
    }

    private List<Object> overlap(int[] first, int[] second) {
        if (first[0] > second[0]) {
            return overlap(second, first);
        }
        List<Object> list = new ArrayList<>(2);
        if (second[0] <= first[1]) {
            list.add(new int[]{Math.min(first[0], second[0]), Math.max(first[1], second[1])});
            list.add(true);
            return list;
        }
        list.add(false);
        return list;
    }
}
