public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.length() > 1) {
            if (s.charAt(1) != '0') {
                dp[1] = dp[0];
                if (Integer.valueOf(s.substring(0, 2)) <= 26) {
                    dp[1]++;
                }
            } else {
                if (Integer.valueOf(s.substring(0, 2)) <= 26) {
                    dp[1]++;
                }
            }
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
            if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26 && s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 2];
            }
            if (dp[i - 1] == 0) {
                return 0;
            }
        }
        return dp[s.length() - 1];
    }
    
    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("100"));
    }
}