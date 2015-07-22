public class Solution {
    public int mySqrt(int x) {
        double ans = x;
        while (abs(ans * ans - x) > 0.0001) {
            ans = (ans + x / ans) / 2;
        }
        return (int) ans;
    }

    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == x / left) ? left : left - 1;
    }
}