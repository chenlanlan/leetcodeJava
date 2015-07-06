import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        combine(candidates, target, 0, sum, results, temp);
        return results;
    }
    private void combine(int[] candidates, int target, int index, int sum, List<List<Integer>> results, List<Integer> temp){
        if (sum > target){
            return;
        }
        if (sum == target){
            results.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            sum += candidates[i];
            temp.add(candidates[i]);
            combine(candidates, target, i, sum, results, temp);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
        return;
    }
    public static void main(String[] args){
        CombinationSum test = new CombinationSum();
        int[] nums = {1, 2, 3};
        System.out.println(test.combinationSum(nums, 3));
    }
}

