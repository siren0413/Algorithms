import java.util.*;


public class DeepIterator implements Iterator<Object>{
	
	private Node node;
	private Stack<Node> stack;
	
	public DeepIterator(List<Object> list){
		this.node = new Node(list, 0);
		this.stack = new Stack<Node>();
	}
	
	@Override
	public boolean hasNext() {
		boolean result = node.i < node.list.size();
		if(!result && !stack.isEmpty()){
			node = stack.pop();
			return hasNext();
		}
		return result;
	}
	
	@Override
	public Integer next() {
		Object obj = node.list.get(node.i);
		node.i++;
		if(obj instanceof Integer){
			return (Integer)obj;
		}else{
			stack.push(node);
			node = new Node((List)obj, 0);
			return (Integer)next();
		}
	}
	
	@Override
	public void remove() {
	}
	
	class Node{
		List<Object> list;
		int i;
		public Node(List<Object> list, int i){
			this.list = list;
			this.i = i;
		}
	}
	
	public static void main(String[] args) {
		List<Object> list = new LinkedList<>();
		List<Object> list2 = new LinkedList<>();
		list2.add(3);
		list2.add(4);
		list.add(1);
		list.add(2);
		list.add(list2);
		list.add(5);
		DeepIterator iter = new DeepIterator(list);
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
