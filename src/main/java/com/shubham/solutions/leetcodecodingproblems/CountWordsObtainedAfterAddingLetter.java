import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
<a href="https://leetcode.com/problems/count-words-obtained-after-adding-a-letter">Link</a>
**/
public class CountWordsObtainedAfterAddingLetter {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<String, Integer> target = new HashMap<>();
        for (String t : targetWords) {
            //targetWords: ["ac", "ca"]
            // If we use set only one occurrence would be present
            String tar = getSortedString(t);
            target.put(tar, target.getOrDefault(tar, 0) + 1);
        }
        int count = 0;
        for (String word : startWords) {
            // Even if startWords has duplicate, we are removing the entry from target map
            // So no chance of duplicate count
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String str = word;
                if (str.contains(String.valueOf(ch)))
                    continue;
                str += ch;
                String updated = getSortedString(str);
                Integer v = target.get(updated);
                if (v != null) {
                    count += v;
                    target.remove(updated);
                }
            }
        }
        return count;
    }

    private String getSortedString(String s) {
        char[] ch = s.toCharArray();
        String ans = "";
        Arrays.sort(ch);
        for (char c : ch) {
            ans += c;
        }
        return ans;
    }
}
