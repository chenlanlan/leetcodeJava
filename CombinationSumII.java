import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        combine(candidates, target, 0, 0, results, temp);
        return results;
    }

    private void combine(int[] candidates, int target, int index, int sum, List<List<Integer>> results, List<Integer> temp) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (!results.contains(temp)) {
                results.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            temp.add(candidates[i]);
            combine(candidates, target, i + 1, sum, results, temp);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        CombinationSumII test = new CombinationSumII();
        int[] nums = {1, 1};
        System.out.println(test.combinationSum2(nums, 1));
    }
}

