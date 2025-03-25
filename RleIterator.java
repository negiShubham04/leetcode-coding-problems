import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/rle-iterator/">Link</a>
 */
public class RLEIterator {
    List<long[]> encoding;
    long currIndex;
    long encodingIndex;

    public RLEIterator(int[] encoding) {
        this.currIndex = 0;
        List<long[]> newEncoding = new ArrayList<>();
        long start = 0, end;
        for (int i = 0; i < encoding.length; i += 2) {
            int time = encoding[i];
            int value = encoding[i + 1];
            end = start + time - 1;
            newEncoding.add(new long[] {value, start, end});
            start = end + 1;
        }

        this.encoding = newEncoding;
    }

    public int next(int n) {
        long index = currIndex + n - 1;
        currIndex = index + 1;
        int len = encoding.size();
        long i;
        for (i = encodingIndex; i < len; i++) {
            long[] en = encoding.get((int) i);
            if (index >= en[1] && index <= en[2]) {
                encodingIndex = i;
                return (int) en[0];
            }
        }
        return -1;
    }
}
