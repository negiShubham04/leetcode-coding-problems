package com.shubham.solutions.leetcodecodingproblems;

import java.util.Stack;


/**
 * <a href="https://leetcode.com/problems/valid-parentheses">Problem link (LC-20)</a>
 */
public class ValidParentheses {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) [Worst case]
     * Approach used = Stack operations
     */
    public boolean isValid(String s) {
        int i, n = s.length();
        Stack<Character> stack = new Stack<>();
        for (i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
