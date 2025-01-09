package com.shubham.solutions.leetcodecodingproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * <a href="https://leetcode.com/problems/insert-interval/">Problem link (LC-57)</a>
 */
public class InsertInterval {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N)<br>
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new LinkedList<>();
        int i, len = intervals.length;
        if(len == 0){
            addToList(new int[][]{{newInterval[0], newInterval[1]}}, ans);
            return ans.toArray(new int[0][]);
        }
        boolean isMergedOnce = false;
        boolean isIntervalAdded = false;
        for (i = 0; i < len; i++) {
            int[] merged = canMerge(intervals[i], newInterval);
            if (merged[0] != -1 && merged[1] != -1) {
                isMergedOnce = true;
                newInterval = merged;
            } else {
                if (isMergedOnce) {
                    ans.add(newInterval);
                    isIntervalAdded = true;
                    isMergedOnce = false;
                }
                ans.add(intervals[i]);
            }
        }
        if (isMergedOnce) {
            ans.add(newInterval);
        } else {
            if (!isIntervalAdded) {
                return addInterval(newInterval, intervals);
            }
        }
        return ans.toArray(new int[0][]);
    }

    private int[][]  addInterval(int[] newInterval, int[][] intervals) {
        List<int[]> ans = new LinkedList<>();
        if (newInterval[0] < intervals[0][0]) {
            ans.add(newInterval);
            addToList(intervals, ans);
            return ans.toArray(new int[0][]);
        }
        if (newInterval[0] > intervals[intervals.length - 1][0]) {
            addToList(intervals, ans);
            ans.add(newInterval);
            return ans.toArray(new int[0][]);
        }
        ans.add(intervals[0]);
        boolean isAdded = false;
        for (int i = 1; i < intervals.length; i++) {
            int before = intervals[i - 1][0];
            int after = intervals[i][0];
            if (!isAdded && newInterval[0] >= before && newInterval[0] <= after) {
                ans.add(newInterval);
                ans.add(intervals[i]);
                isAdded = true;
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[0][]);
    }

    private void addToList(int[][] intervals, List<int[]> ans) {
        ans.addAll(Arrays.asList(intervals));
    }

    private int[] canMerge(int[] interval, int[] newInterval) {
        if (interval[0] > newInterval[0]) return canMerge(newInterval, interval);
        if (newInterval[0] <= interval[1]) {
            return new int[]{interval[0], Math.max(interval[1], newInterval[1])};
        }
        return new int[]{-1, -1};
    }
}
