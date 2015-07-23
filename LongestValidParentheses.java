import java.util.*;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        int max = 0;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + 1 + dp[i + 1];
                if (j < len && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (j + 1 < len) {
                        dp[i] += dp[j + 1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    
    public int longestValidParentheses2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxL= 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); i++) {
            int t = stack.peek();
            if (t != -1 && s.charAt(i) == ')' && s.charAt(t) == '(') {
                stack.pop();
                maxL = Math.max(maxL, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return maxL;
    }
    
    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        System.out.println(test.longestValidParentheses2("(())))"));
    }
}