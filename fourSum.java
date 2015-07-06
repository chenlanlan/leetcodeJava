import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            for (int k = nums.length - 1; k > i + 2; k --){
                int ab = nums[i] + nums[k];
                int c = target - ab;
                int left = i + 1;
                int right = k - 1;
                while (left < right){
                    int sum = nums[left] + nums[right];
                    if (sum == c){
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[left]);
                        result.add(nums[right]);
                        result.add(nums[k]);
                        if (!results.contains(result)){
                            results.add(result);
                        }
                        left ++;
                        right --;
                        while (left < right && nums[left] == nums[left - 1]){
                            left ++;
                        }
                        while (left < right && nums[right] == nums[right + 1]){
                            right --;
                        }
                    }else if (sum < c) {
                        left ++;
                    }else{
                        right --;
                    }
                }
            }
        }
        return results;
    }
    public static void main(String[] args){
        fourSum test = new fourSum ();
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(test.fourSum(nums, 0));
    }
}

