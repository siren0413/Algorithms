import java.util.*;

public class SearchWordsInDict {
	public List<String> search(String s, Set<String> dict){
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> temp = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 0);
			}
			map.put(c, map.get(c)+1);
		}
		List<String> result = new LinkedList<>();
		for(String word: dict){
			temp.putAll(map);
			if(contains(temp, word)){
				result.add(word);
			}
			temp.clear();
		}
		return result;
	}
	
	private boolean contains(Map<Character,Integer> temp, String word){
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(!temp.containsKey(c) || temp.get(c) == 0){
				return false;
			}else{
				temp.put(c, temp.get(c)-1);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("go");
		dict.add("egg");
		dict.add("ego");
		SearchWordsInDict solution = new SearchWordsInDict();
		System.out.println(solution.search("ogeg", dict));
	}
}
