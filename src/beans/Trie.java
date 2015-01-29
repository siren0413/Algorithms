package beans;
import java.util.*;

public class Trie {
	Node root;
	public Trie(){
		root = new Node(' ');
	}
	
	public void insert(String s){
		Node temp = root;
		for(int i = 0; i < s.length();i++){
			char c = s.charAt(i);
			if(!temp.map.containsKey(c)){
				Node node = new Node(c);
				node.count++;
				if(i == s.length()-1){
					node.end = true;
				}
				temp.map.put(c, node);
			}else{
				Node node = temp.map.get(c);
				node.count++;
				if(i == s.length()-1){
					node.end = true;
				}
			}
			temp = temp.map.get(c);
		}
	}
	
	public boolean find(String s){
		Node temp = root;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!temp.map.containsKey(c) || temp.map.get(c).count==0){
				return false;
			}else{
				if(i == s.length()-1){
					return temp.map.get(c).end;
				}
				temp = temp.map.get(c);
			}
		}
		return false;
	}
	
	public List<String> autoComplete(String s){
		StringBuilder sb = new StringBuilder();
		Node temp = root;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			sb.append(c);
			if(!temp.map.containsKey(c) || temp.map.get(c).count==0){
				return new LinkedList<>();
			}else{
				temp = temp.map.get(c);
			}
		}
		List<String> result = new LinkedList<>();
		helper(temp, sb, result);
		return result;
	}
	
	private void helper(Node node, StringBuilder sb, List<String> result){
		if(node.map.isEmpty()){
			result.add(sb.toString());
			return;
		}
		for(Node n: node.map.values()){
			sb.append(n.c);
			helper(n, sb, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	class Node{
		char c;
		boolean end;
		int count;
		Map<Character, Node> map;
		public Node(char c){
			this.c = c;
			map = new HashMap<>();
		}
	}
	
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("team.com");
		trie.insert("tea.in");
		trie.insert("teamwork.org");
		trie.insert("teams.com");
		trie.insert("pot.uk");
		trie.insert("potter.in");
		trie.insert("post.com");
		System.out.println(trie.autoComplete("te"));
		System.out.println(trie.find("team.com"));
	}
}
