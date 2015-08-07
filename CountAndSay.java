public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        StringBuilder ret = new StringBuilder();
        int cnt = 0;
        int round = 1;
        int i;
        while (round < n) {
            cnt = 1;
            ret.setLength(0);
            for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    cnt++;
                } else {
                    ret.append(cnt).append(s.charAt(i - 1));
                    cnt = 1;
                }
            }
            ret.append(cnt).append(s.charAt(i - 1));
            s = ret.toString();
            System.out.println(s);
            round++;
        }
        return ret.toString();
    }
    
    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
        System.out.println(test.countAndSay(1));
    }
}