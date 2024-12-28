package com.shubham.solutions.leetcodecodingproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/plus-one/">Problem link (LC-66)</a>
 */
public class PlusOne {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(N) <br>
     */
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int carry = 1;
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            int sum = digit  + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
        }
        if (carry != 0) {
            ans.add(carry);
        }
        int[] finalAns = new int[ans.size()];
        int index = 0;
        for (i = ans.size() - 1; i >= 0; i--) {
            finalAns[index++] = ans.get(i);
        }
        return finalAns;
    }
}
