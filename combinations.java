import java.util.List;
import java.util.ArrayList;
public class combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        combinations(n, k, 1, 0, res, list);
        return res;
    }
    public void combinations(int n, int k, int start, int index, List<List<Integer>> res, List<Integer> list){
        if (index == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++){
            list.add(i);
            combinations(n, k, i + 1, index + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args){
        combinations test = new combinations();
        System.out.println(test.combine(4, 2));
    }
}