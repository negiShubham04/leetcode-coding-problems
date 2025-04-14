package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">Problem link (LC-1376)</a>
 */
public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int i;
        for (i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            adj.computeIfAbsent(manager[i], x -> new ArrayList<>()).add(i);
        }
        return dfs(adj, headID, informTime);
    }

    private int dfs(Map<Integer, List<Integer>> adj, int node, int[] inform) {
        if (!adj.containsKey(node) || adj.get(node).isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int child : adj.get(node)) {
            max = Math.max(max, inform[node] + dfs(adj, child, inform));
        }
        return max;
    }

}
