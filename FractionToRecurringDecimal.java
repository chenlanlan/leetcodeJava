import java.util.*;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if (numerator == 0) return "0";
        String sign = (numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        res.append(sign);
        res.append(num / den);
        long rem = num % den;
        if (rem == 0) return res.toString();
        res.append(".");
        while (!map.containsKey(rem)) {

            map.put(rem, res.length());
            res.append(10 * rem / den);
            rem = 10 * rem % den;
            if (rem == 0) return res.toString();
        }
        int index = map.get(rem);
        res.insert(index, "(");
        res.append(")");
        return res.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal test = new FractionToRecurringDecimal();
        System.out.println(test.fractionToDecimal(1, 5));
    }
}