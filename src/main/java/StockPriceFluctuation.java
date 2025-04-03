package com.shubham.solutions.leetcodecodingproblems;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/stock-price-fluctuation">Link</a>
 */
public class StockPriceFluctuation {


    static class StockPrice {
        TreeMap<Integer, Integer> timestampToPrice;
        TreeMap<Integer, Set<Integer>> descendingPriceToTimestamp;

        public StockPrice() {
            timestampToPrice = new TreeMap<>(Comparator.reverseOrder());
            descendingPriceToTimestamp = new TreeMap<>(Comparator.reverseOrder());
        }

        public void update(int timestamp, int price) {

            Integer oldPrice = timestampToPrice.get(timestamp);
            if (oldPrice == null) {
                timestampToPrice.put(timestamp, price);
                descendingPriceToTimestamp.computeIfAbsent(price, x -> new HashSet())
                    .add(timestamp);
                return;
            }

            int maxPrice = descendingPriceToTimestamp.firstKey();
            int minPrice = descendingPriceToTimestamp.lastKey();


            if (oldPrice == maxPrice || oldPrice == minPrice) {
                descendingPriceToTimestamp.get(oldPrice).remove(timestamp);
                if (descendingPriceToTimestamp.get(oldPrice).isEmpty()) {
                    descendingPriceToTimestamp.remove(oldPrice);
                }
            }
            if (descendingPriceToTimestamp.containsKey(oldPrice)) {
                descendingPriceToTimestamp.get(oldPrice).remove(timestamp);
                if (descendingPriceToTimestamp.get(oldPrice).isEmpty()) {
                    descendingPriceToTimestamp.remove(oldPrice);
                }
            }
            timestampToPrice.put(timestamp, price);
            descendingPriceToTimestamp.computeIfAbsent(price, x -> new HashSet()).add(timestamp);
        }

        public int current() {
            return timestampToPrice.get(timestampToPrice.firstKey());
        }

        public int maximum() {
            return (descendingPriceToTimestamp.firstKey());
        }

        public int minimum() {
            return (descendingPriceToTimestamp.lastKey());
        }
    }

}
