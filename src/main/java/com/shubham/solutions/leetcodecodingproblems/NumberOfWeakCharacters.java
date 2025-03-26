import java.util.Arrays;
import java.util.Stack;

/**
<a href="https://leetcode.com/problems/the-number-of-weak-characters-in-the-game">Link</a>

**/
public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (v1, v2) -> {
            if (v1[0] == v2[0]) {
                return Integer.compare(v2[1], v1[1]);
            }
            return Integer.compare(v1[0], v2[0]);
        });
        int count = 0;
        int i, n = properties.length;
        Stack<Integer> stack = new Stack<>();
        stack.add(properties[n - 1][1]);
        for (i = n - 2; i >= 0; i--) {
            if (stack.peek() > properties[i][1]) {
                count++;
            } else {
                while (!stack.isEmpty() && stack.peek() <= properties[i][1]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > properties[i][1]) {
                    count++;
                }
            }
            stack.add(properties[i][1]);
        }
        return count;
    }
}
