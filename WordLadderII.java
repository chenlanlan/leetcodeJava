import java.util.*;

public class WordLadderII {
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (dict.size() == 0) {
            return res;
        }
        LinkedList<String> tovisit = new LinkedList<String>();
        tovisit.add(start);
        LinkedList<Integer> levels = new LinkedList<Integer>();
        dict.add(end);
        Set<String> visited = new HashSet<String>();
        Map<String, Map<Integer, Set<String>>> prevs = new HashMap<String, Map<Integer, Set<String>>>();
        prevs.put(start, new HashMap<Integer, Set<String>>());
        int maxLen = Integer.MAX_VALUE;
        int level = 0;
        while (!tovisit.isEmpty()) {
            String currWord = tovisit.pop();
            visited.add(currWord);
            if (!levels.isEmpty()) {
                level = levels.pop();
            }
            if (level > maxLen) break;
            if (currWord.equals(end) && level < maxLen) maxLen = level;
            else {
                for (String s:possMoves(currWord, end, dict, visited)) {
                    if (!tovisit.contains(s)) {
                        tovisit.add(s);
                        levels.add(level + 1);
                    }
                    if (! prevs.containsKey(s)) {
                        Map<Integer, Set<String>> levelprevs = new HashMap<Integer, Set<String>>();
                        Set<String> prevset = new HashSet<String>();
                        levelprevs.put(level, prevset);
                        prevs.put(s, levelprevs);
                    }
                    if (prevs.get(s).containsKey(level)) {
                        prevs.get(s).get(level).add(currWord);
                    }
                }
            }
        }
        res = buildPaths(start, end, prevs);
        return res;
    }
    
    public static List<List<String>> buildPaths(String start, String end, Map<String,Map<Integer,Set<String>>> prevs) {
        List<List<String>> paths = new ArrayList<List<String>>();
        Set<String> prevsteps = null;
        if(prevs.containsKey(end)) {
            for(int i:prevs.get(end).keySet())
                prevsteps = prevs.get(end).get(i);
        }
        if(prevsteps==null || prevsteps.size()==0) {
            if(start.equals(end)) {
                List<String> path = new ArrayList<String>();
                path.add(end);
                paths.add(path);
            }
            return paths;
        } else {
            for(String s: prevsteps) {
                for(List<String> path: buildPaths(start,s,prevs)) {
                    path.add(end);
                    paths.add(path);
                }
            }
            
        }
        return paths;
    }
    
    public static List<String> possMoves(String word, String end, Set<String> dict, Set<String> visited) {
        List<String> moves = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);
                if(dict.contains(newWord) && !visited.contains(newWord)) {
                    moves.add(newWord);
                }
            }
        }
        if (moves.contains(end)) {
            moves = new ArrayList<String>();
            moves.add(end);
        }
        return moves;
    }
    
    public Set<String> getvalue(Map<Integer, Set<String>> map){
        Set<String> res = new HashSet<String>();
        for (int i : map.keySet()){
            res = map.get(i);
            System.out.println(res);
        }
        return res;
    }
    
    public static void main(String[] args) {
        WordLadderII test = new WordLadderII();
        HashSet<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(test.findLadders("hit", "cog", dict));
        Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
        HashSet<String> dict1 = new HashSet<String>(Arrays.asList("hot","dot"));
        HashSet<String> dict2 = new HashSet<String>(Arrays.asList("dog","lot"));
        map.put(1, dict1);
        map.put(2, dict2);
        System.out.println(test.getvalue(map));
    }
}
