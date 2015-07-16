import java.util.*;
public class HappyNumber {
    private HashSet<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int newN = 0;
        while (n > 0) {
            newN += Math.pow((n % 10), 2);
            n = n / 10;
        }
        System.out.println(newN);
        if (set.contains(newN)) return false;
        else {
            set.add(newN);
            return isHappy(newN);
        }
    }
    public static void main(String[] args){
        HappyNumber test = new HappyNumber();
        System.out.println(test.isHappy(19));
    }
}