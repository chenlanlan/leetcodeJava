public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean period = false;
        int e = -1;
        boolean numbersBeforeE = false;
        boolean numbersAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == e + 1 && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (e == -1) {
                    numbersBeforeE = true;
                } else {
                    numbersAfterE = true;
                }
                continue;
            }
            if (s.charAt(i) == '.' && !period && e == -1) {
                period = true;
                continue;
            }
            if (s.charAt(i) == 'e' && e == -1 && numbersBeforeE) {
                e = i;
                continue;
            }
            return false;
        }
        if (e != -1) return numbersBeforeE && numbersAfterE;
        return numbersBeforeE;
    }
}

