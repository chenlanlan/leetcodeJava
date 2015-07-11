public class AddBinary {
    public String addBinary(String a, String b) {
        String ans = new String("");
        int lenA = a.length();
        int lenB = b.length();
        int length = lenA;
        String zero = "";
        for (int i = 0; i < Math.abs(lenA - lenB); i++){
            zero += "0";
        }
        if (lenA > lenB){
            b = zero + b;
        }else{
            a = zero + a;
            length = lenB;
        }
        int add = 0;
        for (int i = length - 1; i >= 0; i--){
            int sum = char2int(a.charAt(i)) + char2int(b.charAt(i)) + add;
            ans += String.valueOf(sum % 2);
            add = sum / 2;
        }
        if (add != 0){
            ans += String.valueOf(add);
        }
        StringBuffer sb = new StringBuffer(ans);
        sb = sb.reverse();
        ans = sb.toString();
        return ans;
    }
    public int char2int(char c){
        return c - '0';
    }
    public static void main(String[] args){
        AddBinary test = new AddBinary();
        System.out.println(test.addBinary("10", "10"));
    }
}