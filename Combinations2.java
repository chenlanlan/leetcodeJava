import java.util.List;
import java.util.ArrayList;

public class Combinations2 {
    public List<List<Character>> combinations2(Character[] chars, int k) {
        List<List<Character>> res = new ArrayList<List<Character>>();
        List<Character> sub = new ArrayList<Character>();
        combine(chars, k, 0, res, sub);
        return res;
    }
    
    public void combine(Character[] chars, int k, int index, List<List<Character>> res, List<Character> sub) {
        if (index == k) {
            res.add(new ArrayList(sub));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (sub.contains(chars[i])) continue;
            sub.add(chars[i]);
            combine(chars, k, index + 1, res, sub);
            sub.remove(sub.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Combinations2 test = new Combinations2();
        Character[] chars = {'a', 'b', 'c'};
        System.out.println(test.combinations2(chars, 2));
    }
}