import java.util.*;

import beans.Interval;

public class BusyInterval {
	public List<Integer> busyInterval(List<Interval> intervals){
		List<Integer> result = new LinkedList<>();
		List<Point> list = new LinkedList<>();
		for(Interval interval: intervals){
			Point start = new Point(interval.start, Status.START);
			Point end = new Point(interval.end, Status.END);
			list.add(start);
			list.add(end);
		}
		Collections.sort(list, new PointComparator());
		int overlapCounter = 0, max = 0, start = 0, end = 0;
		for(int i = 1; i < list.size(); i++){
			Point p = list.get(i);
			if(p.status == Status.START){
				overlapCounter++;
				if(overlapCounter > max){
					max = overlapCounter;
					start = p.time;
					end = list.get(i+1).time;
				}
			}else{
				overlapCounter--;
			}
		}
		if(max == 0){
			return result;
		}
		result.add(start);
		result.add(end);
		return result;
	}
	
	class Point{
		Status status; 
		int time;
		public Point(int time, Status status){
			this.status = status;
			this.time = time;
		}
	}
	
	enum Status{
		START,END
	}
	
	class PointComparator implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			return Integer.valueOf(o1.time).compareTo(o2.time);
		}
	}
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 4);
		Interval i2 = new Interval(3, 8);
		Interval i3 = new Interval(5, 10);
		Interval i4 = new Interval(6, 12);
		Interval i5 = new Interval(11, 14);
		List<Interval> intervals = new LinkedList<>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals.add(i5);
		BusyInterval solution = new BusyInterval();
		System.out.println(solution.busyInterval(intervals));
	}
}






















