import beans.Interval;
import java.util.*;

public class FindFreeTimeInterval {
	public List<Interval> findFreeInterval(List<List<Interval>> intervals){
		if(intervals == null || intervals.size() == 0) return null;
		List<Interval> list = intervals.get(0);
		for(int i = 1; i < intervals.size(); i++){
			list.addAll(intervals.get(i));
		}
		Collections.sort(list,new IntervalComparator());
		mergeInterval(list);
		List<Interval> result = new LinkedList<>();
		for(int i = 0; i < list.size()-1; i++){
			Interval A = list.get(i);
			Interval B = list.get(i+1);
			Interval free = new Interval(A.end, B.start);
			result.add(free);
		}
		return result;
	}
	
	private void mergeInterval(List<Interval> intervals){
		int i = 0;
		while(i < intervals.size()-1){
			Interval A = intervals.get(i);
			Interval B = intervals.get(i+1);
			if(A.end >= B.start){
				A.start = Math.min(A.start, B.start);
				A.end = Math.max(A.end, B.end);
				intervals.remove(B);
				continue;
			}
			i++;
		}
	}
	
	class IntervalComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval o1, Interval o2) {
			return Integer.valueOf(o1.start).compareTo(o2.start);
		}
	}
	
	public static void main(String[] args) {
		List<List<Interval>> intervals = new LinkedList<>();
		List<Interval> Alist = new LinkedList<>();
		List<Interval> Blist = new LinkedList<>();
		Alist.add(new Interval(1, 5));
		Alist.add(new Interval(10, 14));
		Alist.add(new Interval(19, 20));
		Alist.add(new Interval(21, 24));
		Alist.add(new Interval(27, 30));
		Blist.add(new Interval(3, 5));
		Blist.add(new Interval(12, 15));
		Blist.add(new Interval(18, 21));
		Blist.add(new Interval(23, 24));
		intervals.add(Alist);
		intervals.add(Blist);
		FindFreeTimeInterval solution = new FindFreeTimeInterval();
		System.out.println(solution.findFreeInterval(intervals));
	}
}
