package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;


/**
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/">Problem link (LC-380)</a>
 */
public class InsertDeleteGetRandom {

    /**
     * Time complexity = O(1) Average for each operation <br>
     * Space complexity = O(N) <br>
     * Approach: For remove and insert Hashset/hashmap is a good choice <br>
     * but for getting random element, you need to maintain a list and the index should be stored in map <br>
     * Also handle the insert/remove case carefully
     */
    static class RandomizedSet {

        Map<Integer, Integer> valueToListIndex;
        List<Integer> list;

        public RandomizedSet() {
            valueToListIndex = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (valueToListIndex.containsKey(val)) {
                return false;
            }
            list.add(val);
            valueToListIndex.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (valueToListIndex.containsKey(val)) {
                int index = valueToListIndex.get(val);
                valueToListIndex.remove(val);
                if (list.size() - 1 != index) {
                    // if list size is not 1 while removing
                    int lastValue = list.get(list.size() - 1);
                    list.set(index, lastValue);
                    valueToListIndex.put(lastValue, index);
                }
                list.remove(list.size() - 1);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int size = list.size();
            int randomIndex = (new Random().nextInt(size));
            return list.get(randomIndex);
        }
    }
}
