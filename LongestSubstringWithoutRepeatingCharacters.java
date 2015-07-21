import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int maxLen = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.put(s.charAt(right));
            } else {
                if (right - left > maxLen) maxLen = right - left;
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("abcdbhg"));
    }
}