import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            maxArea = Math.max(largestRectangleArea(height), maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[stack.peek()] < height[i]) {
                stack.push(i);
            } else {
                int start = stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, height[start] * width);
                i--;
            }
        }
        while (!stack.empty()) {
            int start = stack.pop();
            int width = stack.empty() ? height.length : height.length - stack.peek() - 1;
            area = Math.max(area, height[start] * width);
        }
        return area;
    }

    public static void main(String[] args) {
        MaximalRectangle test = new MaximalRectangle();
        char[][] matrix = {{'1', '1', '1'}, {'0', '1', '1'}};
        System.out.println(test.maximalRectangle(matrix));
    }
}