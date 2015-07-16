import java.util.Stack;
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[stack.peek()] < height[i]) {
                stack.push(i);
            }else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty()? height.length: height.length - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }
    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int[] height = {1, 2, 3};
        System.out.println(test.largestRectangleArea(height));
    }
}