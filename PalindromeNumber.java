public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int rev = 0, ori = x;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (rev == ori) ? true : false;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(121));
    }
}