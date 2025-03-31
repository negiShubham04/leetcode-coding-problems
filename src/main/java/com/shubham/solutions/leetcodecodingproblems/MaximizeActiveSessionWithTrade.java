/**
 * <a href="https://leetcode.com/problems/maximize-active-section-with-trade-i/">Link</a>
 */
public class MaximizeActiveSessionWithTrade {


    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int i;
        int ones = 0, allOnes = 0;
        for (i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                allOnes++;
            }
        }
        // Sliding window apporach;
        // 00001110001100000
        // First pass:
        // leftZero = 4
        // ones = 3
        // rightZero = 3
        // Second pass:
        // leftZero = rightZero = 3
        // ones = 2
        // rightZero = 5
        int leftZeroes = 0;
        int rightZeroes = 0;
        i = 0;
        int ans = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == '1') {
                ones++;
                i++;
            }
            while (i < n && s.charAt(i) == '0') {
                rightZeroes++;
                i++;
            }
            if (ones != 0 && leftZeroes != 0 && rightZeroes != 0) {
                ans = Math.max(ans, leftZeroes + rightZeroes);
            }
            leftZeroes = rightZeroes;
            rightZeroes = 0;
            ones = 0;
        }
        return ans + allOnes;
    }
}
