public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int i = s.length();
        while (i >= 1) {
            if (isPalindrome(s.substring(0, i))) {
                break;
            }
            i--;
        }
        String pre = reverse(s.substring(i));
        String ans = pre + s;
        return ans;
    }
    
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        return new String(sb);
    }
    
    public static void main(String[] args) {
        ShortestPalindrome test = new ShortestPalindrome();
        System.out.println(test.shortestPalindrome("aabba"));
    }
}