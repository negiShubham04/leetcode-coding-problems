package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses">Problem link (LC-22)</a>
 */
public class GenerateParenthesis {
    // Exponential time complexity
    public List<String> generateParenthesis(int n) {
        return findGenerateParenthesis(0, 0, n, "");
    }

    private List<String> findGenerateParenthesis(int openBrackets, int closeBrackets, int n, String s) {
        List<String> ans = new ArrayList<>();
        if (openBrackets == n && closeBrackets == n) {
            ans.add(s);
            return ans;
        }
        if (openBrackets > n || closeBrackets > n) {
            return ans;
        }
        ans.addAll(findGenerateParenthesis(openBrackets + 1, closeBrackets, n, s + "("));
        if (openBrackets > closeBrackets) {
            ans.addAll(findGenerateParenthesis(openBrackets, closeBrackets + 1, n, s + ")"));
        }
        return ans;
    }
}
