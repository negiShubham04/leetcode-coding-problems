package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/course-schedule-ii/">Problem link (LC-210)</a>
 */
public class CourseScheduleII {

    /**
     * TC = O(V+E) <br>
     * SC = O(V)  <br>
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pre : prerequisites) {
            adj.computeIfAbsent(pre[1], x -> new LinkedList<>()).add(pre[0]);
        }
        int[] inDegree = new int[numCourses];
        for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
            for (int value : entry.getValue()) {
                inDegree[value]++;
            }
        }
        int i;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            ans.add(node);
            for (int neighbour : adj.getOrDefault(node, List.of())) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if (ans.size() != numCourses) {
            ans = new ArrayList<>();
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
