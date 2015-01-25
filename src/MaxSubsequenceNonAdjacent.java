
public class MaxSubsequenceNonAdjacent {
	public int maxSequence(int[] A){
		int[] dp = new int[A.length];
		return helper(A, 0, dp);
	}
	
	private int helper(int[] A, int i, int[] dp){
		if(i >= A.length){
			return 0;
		}
		if(dp[i]!=0){
			return dp[i];
		}
		int max = Math.max(helper(A,i+2,dp) + A[i], helper(A, i+1, dp));
		dp[i] = max;
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {5,1,2,4,5,6};
		MaxSubsequenceNonAdjacent solution = new MaxSubsequenceNonAdjacent();
		System.out.println(solution.maxSequence(A));
	}
}
