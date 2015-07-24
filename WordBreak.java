import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        if (wordDict.contains(s.substring(0, 1))) {
            dp[0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && wordDict.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                } else if (wordDict.contains(s.substring(0, i + 1))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n - 1];
    }
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        HashSet<String> wordDict = new HashSet<String>(Arrays.asList("abc", "c"));
        System.out.println(test.wordBreak("abcc", wordDict));
    }
}