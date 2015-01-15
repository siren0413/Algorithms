
public class DecodeWays {
	public static int decodeWays(String s){
		if(s == null || s.isEmpty()) return 0;
		int[] dp = new int[s.length()];
		return helper(s, 0, dp);
	}
	
	private static int helper(String s, int i, int[] dp){
		if(i == s.length()){
			return 1;
		}
		if(dp[i]!=0) return dp[i];
		dp[i] += helper(s, i+1, dp);
		if(i+1 < s.length() && s.charAt(i)!='0' && Integer.valueOf(s.substring(i, i+2)) <= 26){
			dp[i] += helper(s, i+2, dp);
		}
		return dp[i];
	}
	
	public static void main(String[] args) {
		System.out.println(decodeWays("123"));
	}
}
