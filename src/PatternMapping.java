import java.util.*;

public class PatternMapping {
	public boolean isMapping(String pattern, String input){
		Map<Character,String> map = new HashMap<>();
		return helper(pattern, input, 0, 0, map);
	}
	
	private boolean helper(String pattern, String input, int i , int j, Map<Character,String> map){
		if(i == pattern.length() && j == input.length()){
			return true;
		}
		if(i == pattern.length() || j == input.length()){
			return false;
		}
		char c = pattern.charAt(i);
		if(map.containsKey(c)){
			String s = map.get(c);
			if(j+s.length() <= input.length() && s.equals(input.substring(j,j+s.length()))){
				return helper(pattern, input,i+1,j+s.length(), map);
			}else{
				return false;
			}
		}else{
			for(int k = j+1;k < input.length(); k++){
				String s = input.substring(j, k);
				map.put(c,s);
				if(helper(pattern,input,i+1,k,map)){
					return true;
				}
				map.remove(c);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		PatternMapping solution = new PatternMapping();
		System.out.println(solution.isMapping("abba", "redbluebluered"));
		System.out.println(solution.isMapping("aaaa", "asdasdasdasd"));
		System.out.println(solution.isMapping("aabb", "xyzabcxyzabc"));
	}
}
