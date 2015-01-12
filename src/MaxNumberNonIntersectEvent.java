import java.util.Arrays;
import java.util.Comparator;



public class MaxNumberNonIntersectEvent {
	public static int maxNumEvent(Event[] events){
		if(events == null || events.length == 0){
			return 0;
		}
		Arrays.sort(events, new EventComparator());
		int max = 0;
		for(int i = 0; i < events.length;){
			if(i == events.length-1){
				max++;
				break;
			}
			Event e1 = events[i];
			Event e2 = events[i+1];
			if(e1.end > e2.start){
				i += 2;
			}else{
				max++;
				i++;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Event[] events = new Event[5];
		events[0] = new Event(0,2);
		events[1] = new Event(1,3);
		events[2] = new Event(3,4);
		events[3] = new Event(4,4);
		events[4] = new Event(5,7);
		System.out.println(maxNumEvent(events));
	}
}

class Event{
	int start, end;
	public Event(int start, int end){
		this.start = start;
		this.end = end;
	}
}

class EventComparator implements Comparator<Event>{
	@Override
	public int compare(Event o1, Event o2) {
		return Integer.valueOf(o1.start).compareTo(o2.start);
	}
}
