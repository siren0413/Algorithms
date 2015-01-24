
public class NumSubstringPalindrome {
	public static int numPalindrome(String s){
		if(s == null || s.isEmpty()) return 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		int num = 0;
		for(int j = 0; j < s.length(); j++){
			for(int i = 0; i <= j; i++){
				if(i == j){
					dp[i][j] = true;
					num++;
				}else if(s.charAt(i) == s.charAt(j) && (j-i <=2 || dp[i+1][j-1])){
					dp[i][j] = true;
					num++;
				}
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(numPalindrome("abbba"));
	}
}
