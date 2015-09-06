public class Solution {
    public int hIndex(int[] citations) {
        int i = 0, j = citations.length - 1, n = citations.length;
        while (i <= j) {
            int k = (i + j) / 2;
            int v = citations[k];
            int h = n - k;
            if (v >= h) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return n - j - 1;
    }
    
}