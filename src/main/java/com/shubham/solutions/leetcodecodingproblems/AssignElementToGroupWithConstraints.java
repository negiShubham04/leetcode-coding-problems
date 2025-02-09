package com.shubham.solutions.leetcodecodingproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/assign-elements-to-groups-with-constraints/">Problem link (LC-3447)</a>
 */
public class AssignElementToGroupWithConstraints {

    public int[] assignElements(int[] groups, int[] elements) {
        Map<Integer, Integer> elementToIndex = new HashMap<>();
        int index = 0;
        for (int element : elements) {
            if (!elementToIndex.containsKey(element)) {
                elementToIndex.put(element, index);
            }
            index++;
        }
        int[] ans = new int[groups.length];
        index = 0;
        for (int group : groups) {
            ans[index++] = findElement(group, elementToIndex);
        }
        return ans;
    }

    private int findElement(int group, Map<Integer, Integer> elementToIndex) {
        int index = Integer.MAX_VALUE;
        int sqrt = (int) Math.ceil(Math.sqrt(group));
        for (int i = 1; i <= sqrt; i++) {
            if (group % i == 0) {
                // 'i' is  divisor of the group
                if (elementToIndex.containsKey(i)) {
                    index = Math.min(index, elementToIndex.get(i));
                }
                // if 'i' is divisor then group/i is also divisor
                int otherDivisor = group / i;
                if (elementToIndex.containsKey(otherDivisor)) {
                    index = Math.min(index, elementToIndex.get(otherDivisor));
                }
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
