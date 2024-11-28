package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/add-binary">Problem link (LC-67)</a>
 */
public class AddBinary {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1)[Except output] <br>
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        int x, y;
        String ans = "";
        while (i >= 0 && j >= 0) {
            x = a.charAt(i) - '0';
            y = b.charAt(j) - '0';
            sum = x + y + carry;
            carry = sum / 2;
            ans = (sum % 2) + ans;
            i--;
            j--;
        }
        while (i >= 0) {
            x = a.charAt(i) - '0';
            sum = carry + x;
            carry = sum / 2;
            ans = (sum % 2) + ans;
            i--;
        }
        while (j >= 0) {
            x = b.charAt(j) - '0';
            sum = carry + x;
            carry = sum / 2;
            ans = (sum % 2) + ans;
            j--;
        }
        if (carry == 1) {
            ans = carry + ans;
        }
        return ans;
    }
}
