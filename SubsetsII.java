import java.util.List;
import java.util.ArrayList;
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, result, results);
        return results;
    }
    public void dfs(int[] nums, int index, List<Integer> result, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(result));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            result.add(nums[i]);
            dfs(nums, i + 1, result, results);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args){
        SubsetsII test = new SubsetsII();
        int[] nums = {1, 2, 2};
        System.out.println(test.subsets(nums));
    }
}

