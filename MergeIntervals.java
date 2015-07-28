/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.isEmpty()) {
            return res;
        }
        Collections.sort(intervals, new IntervalComparator());
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval it1 = intervals.get(i);
            Interval it2 = res.get(res.size() - 1);
            if (it1.start <= it2.end) {
                it2.end = Math.max(it1.end, it2.end);
            } else {
                res.add(it1);
            }
        }
        return res;
    }
}

class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval it1, Interval it2) {
        return it1.start - it2.start;
    }
}