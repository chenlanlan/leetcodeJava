public class Solution {
    public int rob(int[] nums) {
        return Math.max(circleRob(nums, true), circleRob(nums, false));
    }
    
    private int circleRob(int[] nums, boolean robFirst) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = robFirst? nums[0] : 0;
        for (int i = 2; i < dp.length; i++) {
            if (i != dp.length - 1) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            } else {
                dp[i] = robFirst? dp[i - 1] : Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
        }
        return dp[dp.length - 1];
    }
}