package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;


/**
 * <a href="https://leetcode.com/problems/evaluate-division">Problem link (LC-399)</a>
 */
public class EvaluateDivision {

    /**
     * TC = O(N + Q * N) equation = N, queries = Q <br>
     * SC = O(N)  <br>
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> adj = new HashMap<>();
        int index = 0;
        Set<String> variables = new HashSet<>();
        for (List<String> equation : equations) {
            String first = equation.get(0);
            String second = equation.get(1);
            variables.add(first);
            variables.add(second);
            double value = values[index];
            index++;
            adj.computeIfAbsent(first, x -> new LinkedList<>()).add(new Node(second, value));
            adj.computeIfAbsent(second, x -> new LinkedList<>()).add(new Node(first, 1 / value));
        }
        double[] ans = new double[queries.size()];
        index = 0;
        for (List<String> query : queries) {
            String first = query.get(0);
            String second = query.get(1);
            ans[index++] = calculateValue(first, second, adj, variables);
        }
        return ans;
    }

    private double calculateValue(String source, String destination, Map<String, List<Node>> adj, Set<String> variables) {
        Set<String> vis = new HashSet<>();
        return dfs(source, destination, adj, vis, variables);
    }

    private double dfs(String source, String destination, Map<String, List<Node>> adj, Set<String> vis, Set<String> variables) {
        if (!variables.contains(source) || !variables.contains(destination)) {
            return -1;
        }
        if (source.equals(destination)) {
            return 1;
        }
        if (vis.contains(source) || vis.contains(destination)) {
            return -1;
        }
        vis.add(source);
        for (Node neighbour : adj.getOrDefault(source, List.of())) {
            double v = dfs(neighbour.value, destination, adj, vis, variables);
            if (v != -1) {
                return 1 * neighbour.distance * v;
            }
        }
        return -1;
    }

    private static class Node {
        double distance;
        String value;

        public Node(String value, double distance) {
            this.distance = distance;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "distance=" + distance +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
