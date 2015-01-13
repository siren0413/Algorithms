import java.util.*;


public class DecodeLanguage {
	public static List<String> decode(List<String> list){
		if(list == null || list.size() == 0) return list;
		List<Node> nodes = new ArrayList<>();
		Map<String, Node> map = new HashMap<>();
		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			for(int j = 0; j < s.length()-1; j++){
				String val1 = String.valueOf(s.charAt(j));
				String val2 = String.valueOf(s.charAt(j+1));
				if(!map.containsKey(val1)){
					map.put(val1,new Node(val1));
				}
				if(!map.containsKey(val2)){
					map.put(val2,new Node(val2));
				}
				Node node = map.get(val1);
				Node adj = map.get(val2);
				node.adjacents.add(adj);
				nodes.add(node);
			}
		}
		List<String> result = new LinkedList<>();
		for(Node node: nodes){
			visit(node, result);
		}
		return result;
	}
	
	private static void visit(Node n, List<String> result){
		if(n.temp == true){
			System.out.println("not DAG");
			return;
		}
		if(n.perm == true) return;
		n.temp = true;
		for(Node node: n.adjacents){
			visit(node, result);
		}
		result.add(0, n.val);
		n.temp = false;
		n.perm = true;
	}
	
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("01");
		list.add("069");
		list.add("054");
		list.add("20");
		list.add("2354");
		list.add("76");
		list.add("876");
		System.out.println(decode(list));
	}
}

class Node{
	String val;
	boolean temp, perm;
	List<Node> adjacents;
	public Node(String val){
		this.val = val;
		this.temp = false;
		this.perm = false;
		adjacents = new ArrayList<>();
	}
}