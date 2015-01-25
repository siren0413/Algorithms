import java.util.*;

public class DeepIterator2 implements Iterator<Integer>{
	List<Object> list;
	int i;
	Stack<DeepIterator2> stack;
	
	private DeepIterator2(List<Object> list) {
		this.list = list;
		this.i = 0;
		this.stack = new Stack<>();
	}
	
	@Override
	public boolean hasNext() {
		if(i == list.size()){
			if(stack.isEmpty()){
				return false;
			}else{
				DeepIterator2 iter = stack.pop();
				list = iter.list;
				i = iter.i;
				return hasNext();
			}
		}else{
			Object obj = list.get(i);
			if(obj instanceof Integer){
				return true;
			}else{
				DeepIterator2 copy = new DeepIterator2(list);
				copy.i = i+1;
				copy.stack = stack;
				stack.push(copy);
				this.list = (List<Object>)obj;
				this.i = 0;
				return hasNext();
			}
		}
	}
	
	@Override
	public Integer next() {
		if(i == list.size()){
			return null;
		}
		return (Integer)list.get(i++);
	}
	
	@Override
	public void remove() {
	}
	
	public static void main(String[] args) {
		List<Object> list = new LinkedList<>();
		List<Object> list2 = new LinkedList<>();
		List<Object> list3 = new LinkedList<>();
		list2.add(list3);
//		list2.add(3);
//		list2.add(4);
		list.add(1);
		list.add(2);
		list.add(list2);
		list.add(5);
		DeepIterator2 iter = new DeepIterator2(list);
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
}

