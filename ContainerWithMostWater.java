public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while (left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            if (water > sum) {
                sum = water;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] height = {3, 1, 4, 5};
        System.out.println(test.maxArea(height));
    }
}

