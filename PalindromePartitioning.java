public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        partition(s, temp, res);
        return res;
    }
    
    public void partition(String s, List<String> temp, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList(temp));
        }
        for (int i = 1; i < s.length() + 1; i++) {
            if (isPalindrome(s.substring(0, i))) {
                temp.add(s.substring(0, i));
                partition(s.substring(i), temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}