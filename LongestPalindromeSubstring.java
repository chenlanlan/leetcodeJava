public class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return null;
        if (s.length() == 1) return s;
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String temp = helper(s, i, i);
            longest = Math.max(longest, temp.length());
            temp = helper(s, i, i + 1);
            longest = Math.max(longest, temp.length());
        }
        return longest;
    }
    
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String sub = s.substring(begin + 1, end);
        return sub;
    }
}