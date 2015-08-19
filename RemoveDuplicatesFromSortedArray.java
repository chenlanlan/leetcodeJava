public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[j] == nums[i + 1]) {
                count++;
            } else if (count > 0) {
                nums[i - count + 1] = nums[i + 1];
                j = i + 1;
            } else {
                j = i + 1;
            }
        }
        return nums.length - count;
    }
    
}