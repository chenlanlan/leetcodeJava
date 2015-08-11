public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        Arrays.sort(nums);
        int median = 0;
        int n = nums.length;
        if (n % 2 == 1) {
            median = nums[n / 2];
        } else {
            median = nums[n / 2 - 1];
        }
        return median;
    }
}