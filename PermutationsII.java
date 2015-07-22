import java.util.List;
import java.util.ArrayList;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            if (!canSwap(nums, index, i)) continue;
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

    public boolean canSwap(int[] nums, int h, int k) {
        while (nums[h] != nums[k] && h < k) {
            h++;
        }
        if (h == k) return true;
        else return false;
    }

    public static void main(String[] args) {
        PermutationsII test = new PermutationsII();
        int[] nums = {1, 1, 3};
        System.out.println(test.permuteUnique(nums));
    }
}