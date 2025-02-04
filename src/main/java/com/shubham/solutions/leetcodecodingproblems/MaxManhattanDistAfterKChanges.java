package com.shubham.solutions.leetcodecodingproblems;

import java.util.Map;


/**
 * <a href="https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes">LC-3443</a>
 */
public class MaxManhattanDistAfterKChanges {

    Map<Character, Character> map = Map.of('N', 'S',
            'S', 'N',
            'E', 'W',
            'W', 'E');
    Map<Character, int[]> value = Map.of
            ('N', new int[]{0, 1},
                    'S', new int[]{0, -1},
                    'E', new int[]{1, 0},
                    'W', new int[]{-1, 0});

    public int maxDistance(String s, int k) {
        // Think of changing every S to N or every N to S to go in only one y direction, either +y or -y
        // Think of changing every W to E or every E to W to go in only one x direction, either +x or -x
        // to avoid cancellation
        return Math.max(findMax(s, 'N', 'E', k),
                Math.max(findMax(s, 'S', 'E', k),
                        Math.max(findMax(s, 'N', 'W', k),
                                findMax(s, 'S', 'W', k))));
    }

    private int findMax(String s, char y, char x, int k) {
        int i;
        int dist = 0;
        int[] coord = new int[]{0, 0};
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (k > 0 && (ch == y || ch == x)) {
                ch = map.get(ch);
                k--;
            }
            coord = new int[]{coord[0] + value.get(ch)[0], coord[1] + value.get(ch)[1]};
            dist = Math.max(dist, Math.abs(coord[0]) + Math.abs(coord[1]));
        }
        return dist;
    }
}
