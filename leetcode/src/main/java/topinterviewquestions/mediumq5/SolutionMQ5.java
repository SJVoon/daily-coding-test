package main.java.topinterviewquestions.mediumq5;

/**
 * Question
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 */
public class SolutionMQ5 {

    /**
     * my approach
     * brute force
     *
     * time limit exceeded
     * not accepted
     */
    public String longestPalindromeBruteForce(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j <= s.length(); j++){
                String substr = s.substring(i,j);
                StringBuffer sb = new StringBuffer(substr);
                String sbr = sb.reverse().toString();
                if(substr.equals(sbr) && substr.length()>str.length()){
                    str=substr;
                }
            }
        }
        return str;
    }

    /**
     * sample solution
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
