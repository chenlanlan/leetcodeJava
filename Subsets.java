import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, 0, result, results);
        return results;
    }
    public void dfs(int[] nums, int index, List<Integer> result, List<List<Integer>> results) {
        results.add(new ArrayList(result));
        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            dfs(nums, i + 1, result, results);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args){
        Subsets test = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(test.subsets(nums));
    }
}

