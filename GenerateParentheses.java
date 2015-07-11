import java.util.List;
import java.util.ArrayList;
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        int left = n, right = n;
        generate(left, right, "", res);
        return res;
    }
    public void generate(int left, int right, String s, List<String> res){
        if (left == 0 && right == 0){
            res.add(s);
            return;
        }
        if (left > 0){
            generate(left - 1, right, s + "(", res);
        }
        if (right > left){
            generate(left, right - 1, s + ")", res);
        }
    }
    public static void main(String[] args){
        GenerateParentheses test = new GenerateParentheses();
        System.out.println(test.generateParenthesis(3));
    }
}