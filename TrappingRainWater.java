
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int secondHeight = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                secondHeight = Math.max(secondHeight, height[left]);
                ans = ans + secondHeight - height[left];
                left++;
            } else {
                secondHeight = Math.max(secondHeight, height[right]);
                ans += secondHeight - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        int[] height = {2, 1, 0, 3};
        test.trap(height);
    }
}

