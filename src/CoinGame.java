
public class CoinGame {
	public static int findValue(int[] A){
		if(A == null || A.length == 0) return 0;
		int[][] dp = new int[A.length][A.length];
		return helper(A,0,A.length-1, dp);
	}
	
	private static int helper(int[] A, int i, int j, int[][] dp){
		if(i > j){
			return 0;
		}
		if(dp[i][j]!=0){
			return dp[i][j];
		}
		dp[i][j] = Math.max(A[i] + Math.min(helper(A,i+2,j,dp), helper(A,i+1,j-1,dp)), 
				A[j] + Math.min(helper(A,i+1,j-1, dp), helper(A,i,j-2, dp)));
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		int[] A = {2,7,3,5};
		System.out.println(findValue(A));
	}
}
