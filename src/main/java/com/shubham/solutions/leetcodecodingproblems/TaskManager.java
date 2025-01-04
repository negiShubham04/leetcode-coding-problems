package com.shubham.solutions.leetcodecodingproblems;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/design-task-manager/">Problem link (LC-3408)</a>
 */
public class TaskManager {

    Map<Integer, int[]> map;
    TreeMap<Integer, TreeSet<Integer>> priorityMap;

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        priorityMap = new TreeMap<>(Comparator.reverseOrder());
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            map.put(taskId, new int[]{userId, priority});
            priorityMap.computeIfAbsent(priority, x ->
                    new TreeSet<>(Comparator.reverseOrder())).add(taskId);
        }
    }


    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{userId, priority});
        priorityMap.computeIfAbsent(priority, x ->
                new TreeSet<>(Comparator.reverseOrder())).add(taskId);
    }

    public void edit(int taskId, int newPriority) {
        int[] value = map.get(taskId);
        int oldPriority = value[1];
        map.put(taskId, new int[]{value[0], newPriority});
        priorityMap.get(oldPriority).remove(taskId);
        if (priorityMap.get(oldPriority).isEmpty()) {
            priorityMap.remove(oldPriority);
        }
        priorityMap.computeIfAbsent(newPriority, x ->
                new TreeSet<>(Comparator.reverseOrder())).add(taskId);
    }

    public void rmv(int taskId) {
        int[] value = map.get(taskId);
        map.remove(taskId);
        priorityMap.get(value[1]).remove(taskId);
        if (priorityMap.get(value[1]).isEmpty()) {
            priorityMap.remove(value[1]);
        }
    }

    public int execTop() {
        Map.Entry<Integer, TreeSet<Integer>> entry = priorityMap.firstEntry();
        if (entry != null && !entry.getValue().isEmpty()) {
            int taskId;
            taskId = entry.getValue().first();
            entry.getValue().remove(taskId);
            int[] ints = map.get(taskId);
            map.remove(taskId);
            priorityMap.get(entry.getKey()).remove(taskId);
            if (priorityMap.get(entry.getKey()).isEmpty()) {
                priorityMap.remove(entry.getKey());
            }
            return ints[0];
        }
        return -1;
    }
}
