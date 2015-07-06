import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if (res == target){
                    return res;
                }else if (sum < target){
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        threeSumClosest test = new threeSumClosest ();
        int[] nums = {-1, 1, 2, 1, 3};
        System.out.println(test.threeSumClosest(nums, 2));
    }
}

