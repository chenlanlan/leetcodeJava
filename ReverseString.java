public class ReverseString {
    public String reverse(String s) {
        System.out.println(s);
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            char temp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = temp;
        }
        String ans = new String(str);
        return ans;
    }

    public static void main(String[] args) {
        ReverseString test = new ReverseString();
        System.out.println(test.reverse("ABC"));
    }
}