import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        dfs(nums, 0, result, results);
        return results;
    }
    public void dfs(int[] nums, int idx, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
        results.add(new ArrayList<Integer>(result));
        for (int i = idx; i < nums.length; i++){
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

