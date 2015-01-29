
public class GenericBuySellStock {
	public int profit(int[] A, int k){
		int[][] dp = new int[A.length][k+1];
		return helper(A, k, 0, dp);
	}
	
	private int helper(int[] A, int k, int i, int[][] dp){
		if(k == 0 || i == A.length){
			return 0;
		}
		if(dp[i][k]!=0){
			return dp[i][k];
		}
		int profit = 0;
		for(int m = i+1; m < A.length; m++){
			profit = Math.max(profit , A[m]-A[i] + helper(A, k-1, m, dp));
		}
		profit = Math.max(profit, helper(A, k, i+1, dp));
		dp[i][k] = profit;
		return profit;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 7 ,3, 9, 8, 7, 9, 7, 1, 9};
		GenericBuySellStock solution = new GenericBuySellStock();
		System.out.println(solution.profit(A, 3));
	}
}
