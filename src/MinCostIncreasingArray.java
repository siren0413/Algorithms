
public class MinCostIncreasingArray {
	public int minCost(int[] A){
		int[] dp = new int[A.length];
		return helper(A, A.length-1, dp);
	}
	
	private int helper(int[] A, int i, int[] dp){
		if(i <= 0){
			return 0;
		}
		if(dp[i] != 0){
			return dp[i];
		}
		int cost = 0, min = Integer.MAX_VALUE;
		int k = i-1;
		if(A[k] > A[i]){
			min = Math.min(A[k] + helper(A, k-1, dp), A[i] + helper(A, k, dp));
		}else{
			min = Math.min(min, helper(A, k, dp));
		}
		
		dp[i] = min;
		return dp[i];
	}
	
	public static void main(String[] args) {
		int[] A = {7, 2, 5};
		MinCostIncreasingArray solution = new MinCostIncreasingArray();
		System.out.println(solution.minCost(A));
	}
}
