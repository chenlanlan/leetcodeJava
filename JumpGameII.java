public class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int curMax = 0;
        int curRec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curRec < i) {
                ans++;
                curRec = curMax;
            }
            curMax = Math.max(curMax, nums[i] + i);
        }
        return ans;
    }
}