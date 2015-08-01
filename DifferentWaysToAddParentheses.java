import java.util.*;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer p1 : left) {
                    for (Integer p2 : right) {
                        if (input.charAt(i) == '+') {
                            res.add(p1 + p2) ;
                        } else if (input.charAt(i)== '-') {
                            res.add(p1 - p2);
                        } else {
                            res.add(p1 * p2);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
    
    public static void main(String[] args) {
        DifferentWaysToAddParentheses test = new DifferentWaysToAddParentheses();
        System.out.println(test.diffWaysToCompute("3-1-1-1"));
    }
}