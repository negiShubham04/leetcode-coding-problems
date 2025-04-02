import java.util.*;
/**
<a href="https://leetcode.com/problems/longest-string-chain">link</a>

**/
class LongestStringChain {
     public int longestStrChain(String[] words) {
        Map<String,Integer> cache = new HashMap<>();
        Arrays.sort(words, (v1,v2)->{return Integer.compare(v1.length(),v2.length());});
        int ans=0;
        for(String word: words){
            int best = 0;
            for(int i=0;i<word.length();i++){
              // For word: "abcd". It will generate all substring of length -1 .
              // Output: "abc", "bcd", "acd" 
                String previous = word.substring(0,i)+word.substring(i+1);
                best = Math.max(best, cache.getOrDefault(previous,0)+1);
            }
            cache.put(word, best);
            ans = Math.max(ans, best);
        }   
        return ans;
    }
}
