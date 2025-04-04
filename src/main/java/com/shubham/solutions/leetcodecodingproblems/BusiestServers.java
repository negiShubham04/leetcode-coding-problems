package com.shubham.solutions.leetcodecodingproblems;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/find-servers-that-handled-most-number-of-requestsn">Link</a>
 */
public class BusiestServers {


    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> availableServers = new TreeSet<>();
        int i;
        for (i = 0; i < k; i++) {
            availableServers.add(i);
        }
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        int[] count = new int[k];
        int max = 0;
        for (i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                // Check if any busy server is available to be free
                int[] freeServer = busyServers.poll();
                availableServers.add(freeServer[1]);
            }
            if (availableServers.isEmpty()) {
                continue;
            }
            Integer first = availableServers.ceiling(i % k);
            if (first == null) {
                first = availableServers.first();
            }
            // Server now is no more available
            availableServers.remove(first);
            // Add Server tob busy list
            busyServers.add(new int[] {currTime + load[i], first});
            count[first]++;
            max = Math.max(count[first], max);
        }
        List<Integer> ans = new LinkedList<>();
        for (i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }

}
