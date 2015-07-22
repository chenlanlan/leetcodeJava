import java.util.List;
import java.util.ArrayList;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums == null) return res;
        findPermutations(nums, 0, res);
        return res;
    }

    public void findPermutations(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                temp.add(nums[j]);
            }
            res.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int swap = nums[i];
            nums[i] = nums[index];
            nums[index] = swap;
            findPermutations(nums, index + 1, res);
            swap = nums[i];
            nums[i] = nums[index];
            nums[index] = swap;
        }
        return;
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(test.permute(nums));
    }
}