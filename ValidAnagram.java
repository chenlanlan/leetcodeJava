public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String newS = new String(chars1);
        String newT = new String(chars2);
        if (newS.equals(newT)) {
            return true;
        }
        return false;
    }
    
}