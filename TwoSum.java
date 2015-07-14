import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {1, 3, 9, 2};
        System.out.println(test.twoSum(nums, 5));
    }
}