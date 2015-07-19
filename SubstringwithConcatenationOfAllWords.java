import java.util.*;
public class SubstringwithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        if (s.length() < 1 || words.length < 1) return ans;
        int len = words[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            }else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i <= s.length() - words.length * len; i++) {
            int from = i;
            System.out.println(i);
            String str = s.substring(from, from + len);
            int cnt = 0;
            while (map.containsKey(str) && map.get(str) > 0) {
                map.put(str, map.get(str) - 1);
                cnt++;
                from += len;
                if (from + len > s.length()) break;
                str = s.substring(from, from + len);
            }
            if (cnt == words.length) {
                ans.add(i);
            }
            if (cnt > 0) {
                map.clear();
                for (int j = 0; j < words.length; j++) {
                    if (map.containsKey(words[j])) {
                        map.put(words[j], map.get(words[j]) + 1);
                    }else {
                        map.put(words[j], 1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        SubstringwithConcatenationOfAllWords test = new SubstringwithConcatenationOfAllWords();
        String[] words = {"word","good","best","good"};
        System.out.println(test.findSubstring("wordgoodgoodgoodbestword",words));
    }
}