/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            hm = new HashMap<Double, Integer>();
            int duplicate = 0;
            int maxR = 0;
            for (int j = i + 1; j < points.length; j++) {
                double slope;
                if (isDup(points[i], points[j])) {
                    duplicate++;
                    continue;
                } else {
                    slope = calSlope(points[i], points[j]);
                }
                if (hm.containsKey(slope)) {
                    hm.put(slope, hm.get(slope) + 1);
                    maxR = Math.max(maxR, hm.get(slope));
                } else {
                    hm.put(slope, 1);
                    maxR = Math.max(maxR, 1);
                }
            }
            ans = Math.max(ans, maxR + duplicate);
        }
        return ans + 1;
    }
    
    public boolean isDup(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }
    
    public double calSlope(Point p1, Point p2) {
        double dx = p2.x - p1.x;
        double dy = p2.y - p1.y;
        if (dx == 0) return Double.POSITIVE_INFINITY;
        else if (dy == 0) return 0;
        return dy / dx;
    }
}