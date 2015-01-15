import java.util.*;


public class TextJustification {
	public static List<String> justify(String[] words, int L){
		if(words == null || words.length == 0) return new LinkedList<>();
		int[] dp = new int[words.length];
		List<String> list = new ArrayList<>();
		minCost(words, 0, L, dp);
		int i = 0, j = 0;
		StringBuilder sb = new StringBuilder();
		while(i < words.length){
			
		}
		return list;
	}
	
	private static int minCost(String[] words, int i, int L, int[] dp){
		if(i == words.length){
			return 0;
		}
		if(dp[i] != 0) return dp[i];
		int min = Integer.MAX_VALUE, index = i, cost = 0;
		for(int k = i; k < words.length; k++){
			int len = 0;
			for(int m = i; m <= k; m++){
				len += words[m].length();
			}
			if(L -len -(k-i) < 0) break;
			if(k != words.length-1){
				cost = (int)Math.pow((L - len - (k-i)),2) + minCost(words, k+1, L,  dp);
			}
			if(cost < min){
				min = cost;
				index = k;
			}
		}
		dp[i] = min;
		return min;
	}
	
	public static void main(String[] args) {
		String[] words = {"hello", "world","nihao"};
		System.out.println(justify(words, 10));
	}
}
