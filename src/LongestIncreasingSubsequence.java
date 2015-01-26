
public class LongestIncreasingSubsequence {
	public int LIS(int[] A){
		if(A == null || A.length== 0){
			return 0;
		}
		int[] dp = new int[A.length];
		return helper(A, 0, Integer.MIN_VALUE, dp);
	}
	
	private int helper(int[] A, int i, int prev, int[] dp){
		if(i == A.length){
			return 0;
		}
		if(dp[i]!=0){
			return dp[i];
		}
		int max = 0;
		if(A[i] >= prev){
			max = Math.max(1 + helper(A,i+1,A[i], dp), helper(A, i+1,prev, dp));
		}else{
			max = helper(A,i+1,prev,dp);
		}
		dp[i] = max;
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		System.out.println(solution.LIS(A));
	}
}
