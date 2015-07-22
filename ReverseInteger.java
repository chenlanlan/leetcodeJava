public class ReverseInteger {
    public int reverse(int x) {
        boolean F = false;
        int res = 0;
        if (x < 0) {
            F = true;
            x = Math.abs(x);
        }
        while (x > 0) {
            if ((long) (res) * 10 > Integer.MAX_VALUE) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (F) ? (-1) * res : res;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(123));
    }
}