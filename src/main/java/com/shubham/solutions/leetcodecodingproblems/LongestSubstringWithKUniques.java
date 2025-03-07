package com.shubham.solutions.leetcodecodingproblems;

/**
 * <a href="https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853">Link</a>
 */
public class LongestSubstringWithKUniques {

    /**
     * Sliding window.
     */
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int[] freq = new int[26];
        int ans = Integer.MIN_VALUE;
        while (j < n) {
            char ch = s.charAt(j);
            freq[ch - 'a']++;
            int val = frequency(freq);
            if (val >= k) {
                if (val == k) {
                    ans = Math.max(ans, j - i + 1);
                }
                while (i < j && frequency(freq) > k) {
                    freq[s.charAt(i) - 'a']--;
                    i++;
                }
                if (frequency(freq) == k)
                    ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }


    int frequency(int[] arr) {
        int ans = 0;
        for (int x : arr) {
            if (x > 0) ans++;
        }
        return ans;
    }
}
