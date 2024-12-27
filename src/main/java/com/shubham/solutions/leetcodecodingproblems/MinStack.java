package com.shubham.solutions.leetcodecodingproblems;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/min-stack/">Problem link (LC-155)</a>
 */
public class MinStack {
    Stack<long[]> stack;
    long minElement;

    /**
     * Time complexity = O(1) for each operation <br>
     * Space complexity = O(1) excluding stack space required for operations <br>
     */
    public MinStack() {
        stack = new Stack<>();
        minElement = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (minElement == Long.MAX_VALUE) {
            stack.add(new long[]{val, minElement});
            minElement = val;
        } else {
            stack.add(new long[]{val, minElement + val});
            minElement = Math.min(minElement, val);
        }
    }

    public void pop() {
        long[] top = stack.pop();
        minElement = top[1] - top[0];
    }

    public int top() {
        return (int) stack.peek()[0];
    }

    public int getMin() {
        return (int) minElement;
    }
}
