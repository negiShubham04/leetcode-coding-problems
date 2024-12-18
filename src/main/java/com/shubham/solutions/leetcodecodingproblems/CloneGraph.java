package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/clone-graph/">Problem link (LC-133)</a>
 */
public class CloneGraph {

    /**
     * TC = O(V+E)<br>
     * SC = O(V) <br>
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNewNode = new HashMap<>();
        return cloneGraph(node, oldToNewNode);
    }

    private Node cloneGraph(Node node, Map<Node, Node> oldToNewNode) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        if (oldToNewNode.containsKey(node)) {
            newNode = oldToNewNode.get(node);
            return newNode;
        } else {
            oldToNewNode.put(node, newNode);
        }
        List<Node> newNeighbours = new LinkedList<>();
        for (Node neighbour : node.neighbors) {
            Node newNeighbour = cloneGraph(neighbour, oldToNewNode);
            if (newNeighbour != null) {
                newNeighbours.add(newNeighbour);
            }
        }
        newNode.neighbors = newNeighbours;
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
