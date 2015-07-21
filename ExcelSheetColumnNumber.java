public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += charToNum(s.charAt(i)) * Math.pow(26, s.length() - i - 1);
        }
        return res;
    }

    public int charToNum(char a) {
        return a - 'A' + 1;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
        System.out.println(test.titleToNumber("AB"));
    }
}