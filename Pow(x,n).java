public class Solution {
    public double myPow(double x, int n) {
        if (n = 0) return double 1;
        if (n < 0) return (double) 1 / myPow(x, -n);
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}