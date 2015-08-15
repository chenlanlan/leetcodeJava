public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        List<Integer> temp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        List<Integer> res = new ArrayList<Integer>(temp);
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(addNumber + temp.get(i));
        }
        return res;
    }
}