import java.util.*;
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (h.containsKey(nums[i])){
                int j = h.get(nums[i]);
                if (i - j <= k){
                    return true;
                }
            }
            h.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args){
        ContainsDuplicateII test = new ContainsDuplicateII();
        int[] nums = {1, 0, 1, 1};
        System.out.println(test.containsNearbyDuplicate(nums, 1));
    }
}

