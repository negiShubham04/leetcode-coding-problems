package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/construct-quad-tree">Problem link (LC-427)</a>
 */
public class ConstructQuadTree {

    /**
     * TC = O(2^N) <br>
     * SC = O(N*N)  <br>
     */
    public Node construct(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        return constructTree(0, row - 1, 0, col - 1, grid);
    }

    private Node constructTree(int rowStart, int rowEnd, int colStart, int colEnd, int[][] grid) {
        if (rowStart == rowEnd && colStart == colEnd) {
            return new Node(grid[rowStart][colStart] == 1, true);
        }
        if (rowStart > rowEnd || colStart > colEnd) return null;
        int rowMid = (rowEnd + rowStart) / 2;
        int colMid = (colEnd + colStart) / 2;
        Node node = new Node();
        Node topLeft = constructTree(rowStart, rowMid, colStart, colMid, grid);
        Node topRight = constructTree(rowStart, rowMid, colMid + 1, colEnd, grid);
        Node bottomLeft = constructTree(rowMid + 1, rowEnd, colStart, colMid, grid);
        Node bottomRight = constructTree(rowMid + 1, rowEnd, colMid + 1, colEnd, grid);
        if (allEqualTo(topLeft, topRight, bottomLeft, bottomRight, true) && allLeaves(topLeft, topRight, bottomLeft, bottomRight)) {
           // node.val can be set to true in two cases:
            // Case 1: When all the four grids are leaves and their value is true
            // Case 2: When four grids are not leaves but their value is set to true in else condition
            node.val = true;
            node.isLeaf = true;
            topLeft = null;
            topRight = null;
            bottomLeft = null;
            bottomRight = null;
        } else if (allEqualTo(topLeft, topRight, bottomLeft, bottomRight, false)) {
            node.val = false;
            node.isLeaf = true;
            topLeft = null;
            topRight = null;
            bottomLeft = null;
            bottomRight = null;
        } else {
            node.val = true;
            node.isLeaf = false;
        }
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;
        node.topLeft = topLeft;
        node.topRight = topRight;
        return node;
    }

    private boolean allLeaves(Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        return topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
    }

    private boolean allEqualTo(Node topLeft, Node topRight, Node bottomLeft, Node bottomRight, boolean isOne) {
        return isOne(topLeft, isOne) && isOne(topRight, isOne)
                && isOne(bottomLeft, isOne) && isOne(bottomRight, isOne);
    }

    private boolean isOne(Node topLeft, boolean b) {
        return topLeft != null && topLeft.val == b;
    }


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
