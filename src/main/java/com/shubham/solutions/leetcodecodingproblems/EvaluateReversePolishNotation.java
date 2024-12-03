package com.shubham.solutions.leetcodecodingproblems;

import java.util.Stack;


/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Problem link (LC-150)</a>
 */
public class EvaluateReversePolishNotation {

    /**
     * T. Complexity = O(N)<br>
     * Space Complexity = O(N)<br>
     * Approach = Stack
     */
    public int evalRPN(String[] tokens) {
        int value = 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            value = 0;
            int integerValue = Integer.MIN_VALUE;
            try {
                integerValue = Integer.parseInt(token);
            } catch (Exception ignore) {
            }

            if (integerValue == Integer.MIN_VALUE) {
                Integer op2 = stack.pop();
                Integer op1 = stack.pop();
                char c = token.charAt(0);
                if (c == '+') {
                    value += (op1 + op2);
                } else if (c == '-') {
                    value += (op1 - op2);
                } else if (c == '*') {
                    value += (op1 * op2);
                } else {
                    value += (op1 / op2);
                }
                stack.add(value);
            } else {
                stack.add(integerValue);
            }
        }
        return stack.pop();
    }
}
