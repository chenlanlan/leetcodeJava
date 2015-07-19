public class Solution {
    public void sortColors(int[] nums) {
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = 1;
        }
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sorted[left] = 0;
                left++;
            }else if (nums[i] == 2) {
                sorted[right] = 2;
                right--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sorted[i];
        }
    }
    public void sortColors(int[] nums) {
        int tail0 = 0, head2 = nums.length - 1;
        int cur = 0;
        while (cur <= head2) {
            if (nums[cur] == 0) {
                int temp = nums[cur];
                nums[cur] = nums[tail0];
                nums[tail0] = temp;
                cur++;
                tail0++;
            }else if (nums[cur] == 2) {
                int temp = nums[cur];
                nums[cur] = nums[head2];
                nums[head2] = temp;
                head2--;
            }else {
                cur++;
            }
        }
    }
}