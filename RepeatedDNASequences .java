public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet<String>();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < s.length() - 9; i++) {
            if (!set.add(s.substring(i, i + 10))) {
                res.add(s.substring(i, i + 10));
            }
        }
        return new ArrayList<>(res);
    }
}