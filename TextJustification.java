public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int len = words[i].length();
            int j = i + 1;
            while (j < n && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }
            String line = words[i];
            if (j == n) {
                for (int k = i + 1; k < n; k ++) {
                    line += " " + words[k];
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
            } else {
                int extraWidth = maxWidth - len;
                int widthNum = j - i - 1;
                if (widthNum == 0) {
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        line += " ";
                        for (int p = 0; p < extraWidth / widthNum; p++) {
                            line += " ";
                        }
                        if (k - i <= extraWidth % widthNum) {
                            line += " ";
                        }
                        line += words[k];
                    }
                }
            }
            ans.add(line);
            i = j;
        }
        return ans;
    }
}