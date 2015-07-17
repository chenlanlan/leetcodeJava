public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, ans = n + 1, sum = 0;
        while (end < n) {
            sum += nums[end++];
            while (sum >= s) {
                ans = Math.min(end - start + 1, ans);
                sum -= nums[start++];
            }
        }
        return (ans == n + 1) ? 0 : ans;
    }
}