package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i">LC-3439</a>
 */
public class RescheduleMeetingsForMaxFreeTimeI {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<int[]> events = new ArrayList<>();
        int minTime = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < startTime.length; i++) {
            events.add(new int[]{startTime[i], endTime[i]});
            minTime = Math.min(startTime[i], minTime);
            maxTime = Math.max(endTime[i], maxTime);
        }
        events.sort(Comparator.comparingInt(o -> o[0]));
        if (minTime != 0) {
            events.add(new int[]{0, 0});
        }
        if (maxTime != eventTime) {
            events.add(new int[]{eventTime, eventTime});
        }
        events.sort(Comparator.comparingInt(o -> o[0]));
        List<Integer> gaps = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            int[] curr = events.get(i);
            if (i + 1 < events.size()) {
                int[] next = events.get(i + 1);
                gaps.add(next[0] - curr[1]);
            }
        }
        k = Math.min(gaps.size(), k + 1);
        int i = 0, j = 0;
        int sum = 0;
        int maxSum = 0;
        while (j < gaps.size()) {
            if (j - i + 1 < k) {
                sum += gaps.get(j);
            } else {
                sum += gaps.get(j);
                maxSum = Math.max(maxSum, sum);
                sum -= gaps.get(i);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
