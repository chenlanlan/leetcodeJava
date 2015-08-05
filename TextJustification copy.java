public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (String s : path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!s.equals(".") && !s.equals("..") && !s.equals("")) {
                stack.push(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}