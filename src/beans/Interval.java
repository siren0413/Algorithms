package beans;

public class Interval {
	public int start, end;
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return "("+start+","+end+")";
	}
}
