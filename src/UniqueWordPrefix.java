import java.util.*;

// Using recursion
public class UniqueWordPrefix {
	public Map<String, String> unqiueWordPrefix(List<String> words){
		Map<String, String> result = new HashMap<>();
		helper(words, 0, result);
		return result;
	}
	
	private void helper(List<String> words, int n, Map<String,String> result){
		Map<String, List<String>> map = new HashMap<>();
		for(String word: words){
			String prefix = word.substring(0, n+1);
			if(!map.containsKey(prefix)){
				map.put(prefix,new LinkedList<String>());
			}
			map.get(prefix).add(word);
		}
		for(Map.Entry<String, List<String>> entry: map.entrySet()){
			if(entry.getValue().size()==1){
				result.put(entry.getKey(),entry.getValue().get(0));
			}else{
				helper(entry.getValue(), n+1, result);
			}
		}
	}
	
	public static void main(String[] args) {
		
		// recursion
		List<String> words = new LinkedList<>();
		words.add("zebra");
		words.add("dog");
		words.add("duck");
		words.add("dove");
		UniqueWordPrefix solution = new UniqueWordPrefix();
		System.out.println(solution.unqiueWordPrefix(words));
		
		
	}
}


// use trie
class UniqueWordPrefix2{
	
}






