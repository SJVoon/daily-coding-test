package main.java.topinterviewquestions.mediumq3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Question
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class SolutionMQ3 {

    /**
     * my approach
     * brute force from longest possible substring
     * return first not redundant substring
     *
     * not accepted answer
     * time limit exceeded
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        //start from the longest possible substring
        for(int i = s.length(); i > 0; i--){
            for(int j = 0; (j + i)<=s.length(); j++){
                String substring = s.substring(j, j+i);
                Set<Character> charSet = new HashSet<>();
                for(int m = 0; m < substring.length(); m++){
                    charSet.add(substring.charAt(m));
                }
                if(charSet.size()==substring.length()){
                    return substring.length();
                }
            }
        }
        return 0;
    }

    /**
     * sample solution
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
