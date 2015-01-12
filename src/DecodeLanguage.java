import java.util.*;


public class DecodeLanguage {
	public static List<String> decode(List<String> list){
		if(list == null || list.size() == 0) return list;
		List<Node> nodes = new ArrayList<>();
		Map<String, Node> map = new HashMap<>();
		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			for(int j = 0; j < s.length()-1; j++){
				if(!map.containsKey(String.valueOf(s.charAt(j)))){
					map.put(String.valueOf(s.charAt(j)),new Node(String.valueOf(s.charAt(j))));
				}
				if(!map.containsKey(String.valueOf(s.charAt(j+1)))){
					map.put(String.valueOf(s.charAt(j+1)),new Node(String.valueOf(s.charAt(j+1))));
				}
				Node node = map.get(String.valueOf(s.charAt(j)));
				Node adj = map.get(String.valueOf(s.charAt(j+1)));
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