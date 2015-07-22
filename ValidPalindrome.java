public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return true;
        int left = 0, right = n - 1;
        s = s.toLowerCase();
        while (left <= right) {
            while (!Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
                if (left > right) return true;
            }
            while (!Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
                if (left > right) return true;
            }
            if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome("aA"));
    }
}