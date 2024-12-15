package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self">Problem link (LC-238)</a>
 */
public class ProductOfArrayExceptSelf {

    /**
     * TC = O(N)<br>
     * SC = O(N)<br>
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int i;
        int[] productFromStart = new int[len];
        int[] productFromEnd = new int[len];
        productFromStart[0] = nums[0];
        productFromEnd[len - 1] = nums[len - 1];
        for (i = 1; i < len; i++) {
            productFromStart[i] = productFromStart[i - 1] * nums[i];
        }
        for (i = len - 2; i >= 0; i--) {
            productFromEnd[i] = productFromEnd[i + 1] * nums[i];
        }
        for (i = 0; i < len; i++) {
            int leftProduct = i - 1 >= 0 ? productFromStart[i - 1] : 1;
            int rightProduct = i + 1 < len ? productFromEnd[i + 1] : 1;
            ans[i] = leftProduct * rightProduct;
        }
        return ans;
    }
}
