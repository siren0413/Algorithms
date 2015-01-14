import java.util.*;


public class WordBreak {
	public static boolean wordBreak(String key, Set<String> dict){
		if(key == null) return false;
		int[] dp = new int[key.length()];
		return helper(key, 0, dict, dp);
	}
	
	private static boolean helper(String key, int i, Set<String> dict, int[] dp){
		if(i == key.length()){
			return true;
		}
		if(dp[i] != 0) return dp[i] == 1;
		for(int k = i+1; k <= key.length(); k++){
			String sub = key.substring(i, k);
			if(dict.contains(sub)){
				return helper(key, k, dict, dp);
			}
		}
		dp[i] = -1;
		return false;
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("hello");
		dict.add("world");
		System.out.println(wordBreak("helloworld", dict));
	}
}
