/**
 * <a href="https://leetcode.com/problems/maximum-number-of-points-with-cost">Link</a>
 */
public class MaximumNumberOfPointsWithCost {


    public long maxPoints(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long[][] states = new long[row][col];
        int i, j;
        long[] left = new long[col];
        long[] right = new long[col];
        i = 0;
        for (j = 0; j < col; j++) {
            states[i][j] = points[i][j];
        }
        populateLeft(left, states[i]);
        populateRight(right, states[i]);

        for (i = 1; i < row; i++) {

            for (j = 0; j < col; j++) {
                states[i][j] = points[i][j] + Math.max(left[j], right[j]);
            }
            populateLeft(left, states[i]);
            populateRight(right, states[i]);
        }

        return max(states[row - 1]);
    }

    private void populateLeft(long[] left, long[] states) {
        int len = left.length;
        int i;
        left[0] = states[0];
        for (i = 1; i < len; i++) {
            left[i] = Math.max(states[i], left[i - 1] - 1);
        }
    }

    private void populateRight(long[] right, long[] states) {
        int len = right.length;
        int i;
        right[len - 1] = states[len - 1];
        for (i = len - 2; i >= 0; i--) {
            right[i] = Math.max(states[i], right[i + 1] - 1);
        }
    }

    private long max(long[] arr) {
        long max = Long.MIN_VALUE;
        for (long a : arr) {
            max = Math.max(max, a);
        }
        return max;
    }
}
