public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        int i = 0;
        for (Integer num :set) {
            res[i] = num;
            i++;
        }
        return res;
    }
}