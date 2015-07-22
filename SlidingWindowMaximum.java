import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        res[0] = map.lastKey();
        for (int i = k; i < nums.length; i++) {
            if (map.get(nums[i - k]).size() == 1) {
                map.remove(nums[i - k]);
            } else {
                map.get(nums[i - k]).remove(i - k);
            }
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(i);
                map.put(nums[i], temp);
            }
            res[i - k + 1] = map.lastKey();
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(test.maxSlidingWindow(nums, 3));
    }
}