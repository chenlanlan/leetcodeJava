import java.util.Arrays;

public class ScrambleString {
    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[0][i][j] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                for (int j = 0; j + l <= len; j++) {
                    dp[l - 1][i][j] = false;
                    for (int k = 1; k <= l - 1; k++) {
                        if (dp[k - 1][i][j] && dp[l - k - 1][i + k][j + k]) {
                            dp[l - 1][i][j] = true;
                        } else if (dp[k - 1][i][j + l - k] && dp[l - k - 1][i + k][j]) {
                            dp[l - 1][i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[len - 1][0][0];
    }

    public boolean isScramble(String s1, String s2) {
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String sortedS1 = new String(chars1);
        String sortedS2 = new String(chars2);
        if (s1.length() != s2.length() || !sortedS1.equals(sortedS2)) {
            return false;
        }
        if (s1.length() < 4) {
            return true;
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) || isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ScrambleString test = new ScrambleString();
        System.out.println(test.isScramble("a", "a"));
    }
}