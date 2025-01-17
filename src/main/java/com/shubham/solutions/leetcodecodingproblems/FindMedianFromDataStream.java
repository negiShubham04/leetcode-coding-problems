package com.shubham.solutions.leetcodecodingproblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/find-median-from-data-stream">Problem link (LC-295)</a>
 */
public class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty()) {
            leftMaxHeap.add(num);
            return;
        }
        if (num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }
        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            if (leftMaxHeap.size() > rightMinHeap.size()) {
                rightMinHeap.add(leftMaxHeap.poll());
            } else {
                leftMaxHeap.add(rightMinHeap.poll());
            }
        }

    }

    public double findMedian() {
        int size = leftMaxHeap.size() + rightMinHeap.size();
        if (size % 2 == 0) {
            Integer value1 = leftMaxHeap.poll();
            Integer value2 = rightMinHeap.poll();
            leftMaxHeap.add(value1);
            rightMinHeap.add(value2);
            return (value1 + value2) / 2.0f;
        } else {
            return leftMaxHeap.size() > rightMinHeap.size() ? (double) leftMaxHeap.peek() : (double)
                    rightMinHeap.peek();
        }
    }

}
