import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!h.containsKey(nums[i])) {
                h.put(nums[i], i);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate test = new ContainsDuplicate();
        int[] nums = {3, 1, 4, 5};
        System.out.println(test.containsDuplicate(nums));
    }
}