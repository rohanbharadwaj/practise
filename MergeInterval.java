/**
 * Merge Overlapping Intervals
 * 
 *  Input:[1,3], [2,6], [8,10], [15,18] 
 *	Output: [1,6], [8,10], [15,18]
 *  src : leetcode
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

class IntervalCompare implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
		if (a.start < b.start)
			return -1;
		else if (a.start == b.start) {
			if (a.end < b.end)
				return -1;
			else
				return 1;
		} else
			return 1;
	}
}

public class MergeInterval {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		if (intervals == null)
			return null;
		if (intervals.size() == 1 || intervals.size() == 0)
			return intervals;
		ArrayList<Interval> list = new ArrayList<Interval>();
		Collections.sort(intervals, new IntervalCompare());
		int astart = intervals.get(0).start, aend = intervals.get(0).end;
		int i = 1;
		while (i < intervals.size()) {
			int bstart = intervals.get(i).start, bend = intervals.get(i).end;
			if (aend < bstart) {
				list.add(new Interval(astart, aend));
				astart = bstart;
				aend = bend;
			} else if (aend == bstart) {
				aend = bend;
			} else if (aend < bend) {
				aend = bend;
			}
			i++;
		}
		list.add(new Interval(astart, aend));
		return list;
	}
	public void display(ArrayList<Interval> result) {
		for (Interval ele : result)
			System.out.print("[" + ele.start + "," + ele.end + "], ");
	}
	public static void main(String args[]) {
		MergeInterval obj = new MergeInterval();
		ArrayList<Interval> al = new ArrayList<Interval>();
		al.add(new Interval(1, 3));
		al.add(new Interval(2, 6));
		al.add(new Interval(8, 10));
		al.add(new Interval(15, 18));
		System.out.print("Input:");
		obj.display(al);
		ArrayList<Interval> result = obj.merge(al);
		System.out.println("\nOutput:");
		obj.display(result);
	}
}