/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start) {
                res.add(i);
            } else if (i.start > newInterval.end) {
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(i.end, newInterval.end);
            }
        }
        if (newInterval != null) {
            res.add(newInterval);
        }
        return res;
    }
}