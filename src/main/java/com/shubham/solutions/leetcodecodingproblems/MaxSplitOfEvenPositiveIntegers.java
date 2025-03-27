import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-split-of-positive-even-integers">Link</a>
 */
public class MaxSplitOfEvenPositiveIntegers {

  /**
  Greedy recursion
  **/
    public List<Long> maximumEvenSplit(long sum) {
        List<Long> ans = new ArrayList<Long>();
        if (sum % 2 != 0) return ans;

        if (sum == 2) {
            ans.add(2L);
            return ans;
        }
        if (sum == 4) {
            ans.add(4L);
            return ans;
        }
        return findSplit(sum, 2, sum - 2, new ArrayList<Long>());
    }

    private List<Long> findSplit(long sum, long low, long high, List<Long> ans) {
        if (sum == 0) {
            return ans;
        }
        if (low > sum) return null;

        for (long i = low; i <= high; i += 2) {
            ans.add(i);
            List<Long> a = findSplit(sum - i, low + 2, high, ans);
            if (a != null) {
                return a;
            }
            ans.remove(ans.size() - 1);
        }
        return ans;
    }
}
