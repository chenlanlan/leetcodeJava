import java.util.*;
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        if (s.length() != t.length())return false;
        for (int i = 0; i < s.length(); i++){
            char chrS = s.charAt(i), chrT = t.charAt(i);
            if (!map.containsKey(chrS)){
                if (!map.containsValue(chrT)){
                    map.put(chrS, chrT);
                }else{
                    return false;
                }
            }else{
                if(map.containsKey(chrS) && map.get(chrS) != chrT) return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        IsomorphicStrings test = new IsomorphicStrings();
        System.out.println(test.isIsomorphic("aa", "ab"));
    }
}