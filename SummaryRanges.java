import java.util.ArrayList;
import java.util.List;
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums){
        List<String> res = new ArrayList<String>();
        int n = nums.length;
        if (n == 0) return res;
        int begin, end;
        begin = end = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == end || nums[i] == end + 1){
                end = nums[i];
            }else{
                res.add(format(begin, end));
                begin = end = nums[i];
            }
        }
        res.add(format(begin, end));
        System.out.println(res);
        return res;
    }
    public String format(int begin, int end){
        StringBuffer s = new StringBuffer();
        if (begin == end){
            s.append(begin);
        }else{
            s.append(begin);
            s.append("->");
            s.append(end);
        }
        return s.toString();
    }
    public static void main(String[] args){
        SummaryRanges test = new SummaryRanges();
        int[] a = {-2147483648,-2147483647,2147483647};
        test.summaryRanges(a);
    }
        
}

