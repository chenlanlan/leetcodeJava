import java.util.*;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0, i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                int v = getInt(s, i)[0];
                stack.push(v);
                i = getInt(s, i)[1];
            } else if (c == '*') {
                i++;
                int v = getInt(s, i)[0];
                int v1 = stack.pop();
                v1 *= v;
                stack.push(v1);
                i = getInt(s, i)[1];
            } else if (c == '/') {
                i++;
                int v = getInt(s, i)[0];
                int v1 = stack.pop();
                v1 /= v;
                stack.push(v1);
                i = getInt(s, i)[1];
            } else if (c == '+') {
                i++;
                int v = getInt(s, i)[0];
                stack.push(v);
                i = getInt(s, i)[1];
            } else if (c == '-') {
                i++;
                int v = getInt(s, i)[0];
                stack.push(-1 * v);
                i = getInt(s, i)[1];
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int[] getInt(String s, int i) {
        int[] res = new int[2];
        int number = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
            } else if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
                i++;
            } else {
                break;
            }
        }
        res[0] = number;
        res[1] = i;
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculate("1+ 2 * 2 - 3"));
    }
}