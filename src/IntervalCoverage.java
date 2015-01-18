import java.util.*;

import beans.*;

public class IntervalCoverage {
	public static int coverage(Interval[] intervals){
		if(intervals == null || intervals.length ==0 ) return 0;
		Arrays.sort(intervals, new IntervalComparator());
		Interval interval = intervals[0];
		int cover = 0;
		for(int i = 1; i < intervals.length; i++){
			if(interval.end > intervals[i].start){
				interval.end = Math.max(interval.end, intervals[i].end);
			}else{
				cover += interval.end - interval.start + 1;
				interval = intervals[i];
			}
		}
		cover += interval.end - interval.start + 1;
		return cover;
	}
	
	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(1,3);
		intervals[1] = new Interval(-2,2);
		intervals[2] = new Interval(9,9);
		System.out.println(coverage(intervals));
	}
}

class IntervalComparator implements Comparator<Interval>{
	@Override
	public int compare(Interval o1, Interval o2) {
		return Integer.valueOf(o1.start).compareTo(o2.start);
	}
}
