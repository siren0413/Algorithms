import java.util.*;


public class LeaseDistanceInParagraph {
	public int leastDiff(List<List<Integer>> lists){
		TreeSet<Node> set = new TreeSet<>(new NodeComparator());
		for(List<Integer> list: lists){
			Node dummy = new Node(0), temp = dummy;
			for(Integer n: list){
				temp.next = new Node(n);
				temp = temp.next;
			}
			set.add(dummy.next);
		}
		int min = Integer.MAX_VALUE;
		TreeSet<Node> minSet = new TreeSet<>(new NodeComparator());
		while(true){
			Node last = set.last();
			Node first = set.first();
			if(last.val - first.val < min){
				min = last.val - first.val;
				minSet.clear();
				minSet.addAll(set);
			}
			set.remove(first);
			if(first.next!=null){
				first = first.next;
			}else{
				System.out.println(minSet);
				return min;
			}
			set.add(first);
		}
	}
	
	class Node{
		int val;
		Node next;
		public Node(int val){
			this.val = val;
		}
		@Override
		public String toString() {
			return String.valueOf(val);
		}
	}
	
	class NodeComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return Integer.valueOf(o1.val).compareTo(o2.val);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> lists = new LinkedList<>();
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		List<Integer> l3 = new LinkedList<>();
		l1.add(5);
		l1.add(9);
		l1.add(17);
		l2.add(4);
		l2.add(13);
		l2.add(18);
		l3.add(8);
		l3.add(19);
		l3.add(21);
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		LeaseDistanceInParagraph solution = new LeaseDistanceInParagraph();
		System.out.println(solution.leastDiff(lists));
	}
}
