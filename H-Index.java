public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;
        int i = citations.length - 1;
        while (i >= 0) {
            if (citations[i] > count) {
                count++;
            }
            i--;
        }
        return count;
    }
    
}