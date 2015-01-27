public class LongestIncreasingSubsequence {
	public int LIS(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int[] dp = new int[A.length];
		return helper(A, A.length-1, dp);
	}

	private int helper(int[] A, int i, int[] dp) {
		if (i == 0) {
			return 1;
		}
		if (dp[i] != 0) {
			return dp[i];
		}
		int max = 0;
		if (A[i-1] > A[i]){
			max = Math.max(max, helper(A, i-1, dp));
		}else{
			max = Math.max(max, 1 + helper(A, i-1, dp));
		}
		dp[i] = max;
		return max;
	}

	public static void main(String[] args) {
		//10, 22, 9, 33, 21, 50, 41, 60, 80
		int[] A = { 3,4,5,6,1};
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		System.out.println(solution.LIS(A));
	}
}
