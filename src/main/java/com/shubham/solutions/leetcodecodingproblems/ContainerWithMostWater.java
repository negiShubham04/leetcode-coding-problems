package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water">Problem link (LC-11)</a>
 */
public class ContainerWithMostWater {

    /**
     * Time complexity = O(N) <br>
     * Space complexity = O(1) <br>
     * Approach: two pointer
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int low = 0, high = len - 1;
        int maxArea = 0;
        while (low < high) {
            int area = Math.min(height[low], height[high]) * (high - low);
            maxArea = Math.max(maxArea, area);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
