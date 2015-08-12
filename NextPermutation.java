public class Solution {
    public void nextPermutation(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < last) {
                last = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[nums.length - 1] = last;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        return;
                    }
                }
            }
        }
        return;
    }
}