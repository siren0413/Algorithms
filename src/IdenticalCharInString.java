import java.util.*;

public class IdenticalCharInString {
	public int countIdentical(String s){
		if(s == null || s.isEmpty()) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c,0);
			}
			if(map.get(c)+1 > max){
				max = map.get(c)+1;
			}
			map.put(c, map.get(c)+1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		IdenticalCharInString solution = new IdenticalCharInString();
		System.out.println(solution.countIdentical("coffee tuffee"));
	}
}
