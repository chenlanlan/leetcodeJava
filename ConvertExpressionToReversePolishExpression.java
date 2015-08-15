public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> res = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        
        for (int i = 0; i < expression.length; i++) {
            String str =expression[i];
            if (isOp(str)) {
                if (str.equals("(")) {
                    stack.push(str);
                } else if (str.equals(")")) {
                    while (!stack.isEmpty()) {
                        String p = stack.pop();
                        if (p.equals("(")) {
                            break;
                        }
                        res.add(p);
                    }
                } else {
                    while (!stack.isEmpty() && order(str) <= order(stack.peek())) {
                        res.add(stack.pop());
                    }
                    stack.push(str);
                }
            } else {
                res.add(str);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
    
    public boolean isOp(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")
        || str.equals("(") || str.equals(")");
    }
    
    public int order(String a) {
        if (a.equals("*") || a.equals("/")) {
            return 2;
        } else if (a.equals("+") || a.equals("-")) {
            return 1;
        } else {
            return 0;
        }
    }
}