package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">Problem link (LC-373)</a>
 */
public class FindKPairsWithSmallestSums {

    /**
     * TC = K * (LogK)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        List<List<Integer>> ans = new LinkedList<>();
        Set<Pair> vis = new HashSet<>();
        int i = 0, j = 0;
        vis.add(new Pair(0, 0));
        minHeap.add(new Integer[]{0, 0, nums1[0] + nums2[0]});
        while (!minHeap.isEmpty() && k > 0) {
            Integer[] poll = minHeap.poll();
            k--;
            ans.add(List.of(nums1[poll[0]], nums2[poll[1]]));
            Integer x = poll[0];
            Integer y = poll[1];
            if (y + 1 < nums2.length && !vis.contains(new Pair(x, y + 1))) {
                minHeap.add(new Integer[]{x, y + 1, nums1[x] + nums2[y + 1]});
                vis.add(new Pair(x, y + 1));
            }
            if (x + 1 < nums1.length && !vis.contains(new Pair(x + 1, y))) {
                minHeap.add(new Integer[]{x + 1, y, nums1[x + 1] + nums2[y]});
                vis.add(new Pair(x + 1, y));
            }
        }
        return ans;
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
    }
}
