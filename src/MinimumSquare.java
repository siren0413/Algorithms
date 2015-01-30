
public class MinimumSquare {
	public int minSquare(int n){
		int[] dp = new int[n+1];
		return helper(n,dp);
	}
	
	private int helper(int n, int[] dp){
		if(n == 0){
			return 0;
		}
		if(dp[n]!=0){
			return dp[n];
		}
		int min = n;
		for(int i = (int)Math.sqrt(n); i >= 1; i--){
			min = Math.min(min, helper(n-i*i, dp) + 1);
		}
		dp[n] = min;
		return min;
	}
	
	public static void main(String[] args) {
		MinimumSquare solution = new MinimumSquare();
		System.out.println(solution.minSquare(15));
		System.out.println(solution.minSquare(16));
		System.out.println(solution.minSquare(10));
		System.out.println(solution.minSquare(2));
	}
}
