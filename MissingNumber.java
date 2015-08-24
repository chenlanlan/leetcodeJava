public class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 1; i < nums.length + 1; i ++) {
            result ^= nums[i - 1];
            result ^= i;
        }
        return result;
    }
    
}