import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if (!canBreak(s, dict)) return res;
        helper(s, dict, 0, "", res);
        return res;
    }
    
    public void helper(String s , Set<String> dict, int start, String sol, List<String> res) {
        if (start == s.length()) {
            res.add(sol);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (dict.contains(sub)) {
                helper(s, dict, i + 1, sol + (sol.length() == 0 ? "" : " ") + sub, res);
            }
        }
    }
    
    public boolean canBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
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
        WordBreakII test = new WordBreakII();
        HashSet<String> wordDict = new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(test.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
    }
}