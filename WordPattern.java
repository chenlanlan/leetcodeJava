import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strArray[i])) return false;
            } else if (!map.containsValue(strArray[i])){
                map.put(c, strArray[i]);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        System.out.println(test.wordPattern("abba", "cat cat cat cat"));
    }
}