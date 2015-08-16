public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dpPositive = new int[nums.length];
        int[] dpNegative = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        dpPositive[0] = nums[0] > 0 ? nums[0] : 0;
        dpNegative[0] = nums[0] > 0 ? 0 : nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dpPositive[i] = Math.max(dpPositive[i - 1] * nums[i], nums[i]);
                dpNegative[i] = dpNegative[i - 1] * nums[i];
            } else {
                dpPositive[i] = dpNegative[i - 1] * nums[i];
                dpNegative[i] = Math.min(dpPositive[i - 1] * nums[i], nums[i]);
            }
            max = Math.max(dpPositive[i], max);
        }
        return max;
    }
    
}