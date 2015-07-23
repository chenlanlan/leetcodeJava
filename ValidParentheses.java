import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i  = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (!isMatch(c, s.charAt(i))) return false;
                } else {
                    return false;
                }
            }
        }
        return (stack.isEmpty()) ? true: false;
    }
    
    public boolean isMatch(char c, char s) {
        if (c == '(') return s == ')';
        if (c == '[') return s == ']';
        if (c == '{') return s == '}';
        return false;
    }
    
    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid("({[]})[]{}"));
    }
}