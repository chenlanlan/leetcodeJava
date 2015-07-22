
public class Substring {
    public void Substring(String a) {
        int len = a.length();
        for (int begin = 0; begin < len; begin++) {
            for (int end = begin + 1; end <= len; end++) {
                System.out.println(a.substring(begin, end));
            }
        }
    }

    public static void main(String[] args) {
        Substring test = new Substring();
        test.Substring("abc");
    }
}