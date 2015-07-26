public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t.isEmpty()) return "";
        int i = 0, j = 0;
        int[] Tmap = new int[256];
        int[] Smap = new int[256];
        for (int k = 0; k < t.length(); k++) {
            Tmap[t.charAt(k)]++;
        }
        int find = 0;
        int size = Integer.MAX_VALUE;
        String res = "";
        while (j < s.length()) {
            if (find < t.length()) {
                if (Tmap[s.charAt(j)] > 0) {
                    Smap[s.charAt(j)]++;
                    if (Smap[s.charAt(j)] <= Tmap[s.charAt(j)]) {
                        find++;
                    }
                }
                j++;
            }
            while (find == t.length()) {
                if (j - i < length) {
                    length = j - i;
                    res = s.substring(i, j);
                }
                if (Tmap[s.charAt(i)] > 0) {
                    Smap[s.charAt(i)]--;
                    if (Smap[s.charAt(i)] < Tmap[s.charAt(i)]) find--;
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow("abcd", "abc"));
    }
}