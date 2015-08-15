public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToPN(String[] expression) {
        ArrayList<String> res = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (int i = expression.length - 1; i >=0; i--) {
            String str = expression[i];
            if (isOp(str)) {
                if (str.equals(")")) {
                    stack.push(str);
                } else if (str.equals("(")) {
                    while (!stack.isEmpty()) {
                        String op = stack.pop();
                        if (op.equals("(")) {
                            break;
                        }
                        res.add(op);
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
        ArrayList<String> result = new ArrayList<String>();
        for (int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }
        return result;
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