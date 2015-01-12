import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CloestPoints {
	public static ArrayList<Point> cloestPoints(Point[] points, Point center, int k){
		if(points == null || points.length == 0) return new ArrayList<>();
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, new PointComparator(center));
		for(Point p: points){
			int len = calculateLen(p, center);
			if(maxHeap.size() < k){
				maxHeap.add(p);
			}else{
				if(len < calculateLen(maxHeap.peek(), center)){
					maxHeap.poll();
					maxHeap.add(p);
				}
			}
		}
		ArrayList<Point> list = new ArrayList<>();
		list.addAll(maxHeap);
		return list;
	}
	
	private static int calculateLen(Point A, Point B){
		return (int)Math.pow(A.x - B.x, 2) + (int)Math.pow(A.y - B.y, 2);
	}
	
	public static void main(String[] args) {
		/**
		 *  Input: {(-2, -4), (0, 0), (10, 15), (5, 6), (7, 8), (-10, -30)}, k = 2 
			Output: {(5, 6), (7, 8)}
		 */
		Point[] points = new Point[6];
		points[0] = new Point(-2,-4);
		points[1] = new Point(0,0);
		points[2] = new Point(10,15);
		points[3] = new Point(5,6);
		points[4] = new Point(7,8);
		points[5] = new Point(-10,-30);
		Point center = new Point(5,5);
		for(Point p: cloestPoints(points, center, 2)){
			System.out.print("x:"+p.x+" ");
			System.out.println("y:"+p.y);
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class PointComparator implements Comparator<Point>{
	private Point center;
	public PointComparator(Point center){
		this.center = center;
	}
	@Override
	public int compare(Point o1, Point o2) {
		int len1 = calculateLen(o1, center);
		int len2 = calculateLen(o2, center);
		return Integer.valueOf(len2).compareTo(len1);
	}
	
	private int calculateLen(Point A, Point B){
		return (int)Math.pow(A.x - B.x, 2) + (int)Math.pow(A.y - B.y, 2);
	}
}

