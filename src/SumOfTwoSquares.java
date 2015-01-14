
public class SumOfTwoSquares {
	public static int numWays(int x){
		if(x < 1) return -1;
		int i = 1, j = x/2, cnt = 0;
		while(i <= j){
			int sum = i*i + j*j;
			if(sum == x){
				cnt++;
				i++;
				j--;
			}else if(sum > x){
				j--;
			}else{
				i++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		System.out.println(numWays(50));
	}
}
