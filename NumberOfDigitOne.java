public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int res = 0, highn = n, lowc = 1, lown = 0;
        while (highn > 0) {
            int curn = highn % 10;
            highn = highn / 10;
            if (curn == 1) {
                res += highn * lowc;
                res += lown + 1;
            } else if (curn == 0) res += highn * lowc;
            else res += (highn + 1) * lowc;
            lown = curn * lowc + lown;
            lowc = lowc * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfDigitOne test = new NumberOfDigitOne();
        System.out.println(test.countDigitOne(13));
    }
}