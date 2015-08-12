public class Solution {
    public boolean canJump(int[] nums) {
        int step = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (step > 0) {
                step--;
                step = Math.max(step, nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}