import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 3 and !res.contains(nums[i])){
                    res.add(nums[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityElementII test = new MajorityElementII();
        int[] nums = {1, 2, 3, 1, 1, 2};
        System.out.println(test.majorityElement(nums));
    }
}