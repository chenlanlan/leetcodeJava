public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i > 0 && convert(s.charAt(i)) > convert(s.charAt(i - 1))) {
                res += convert(s.charAt(i)) - 2 * convert(s.charAt(i - 1));
            } else {
                res += convert(s.charAt(i));
            }
        }
        return res;
    }
    
    public int convert(char s) {
        if (s == 'I') return 1;
        if (s == 'V') return 5;
        if (s == 'X') return 10;
        if (s == 'L') return 50;
        if (s == 'C') return 100;
        if (s == 'D') return 500;
        if (s == 'M') return 1000;
        return 0;
    }
}

