public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict.size() == 0) return 0;
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        wordQueue.add(beginWord);
        distanceQueue.add(1);
        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();
            if (currWord.equals(endWord)) {
                return currDistance;
            }
            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArray = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArray[i] = c;
                    String newWord = new String(currCharArray);
                    if (wordDict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        wordDict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}