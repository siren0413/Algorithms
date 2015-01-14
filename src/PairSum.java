import java.util.*;

public class PairSum {
	public static void findPair(int[] A){
		if(A == null || A.length == 0) return;
		Arrays.sort(A);
		for(int i = 0; i < A.length; i++){
			for(int j = i+1; j < A.length; j++){
				helper(A, i, j);
			}
		}
	}	
	
	private static void helper(int[] A, int i, int j){
		if(i >= j) return;
		int m = i+1, n = j-1;
		while(m < n){
			int p1 = A[i]+A[j];
			int p2 = A[m]+A[n];
			if(p1 == p2){
				System.out.println(i+" "+j+" "+m+" "+n);
				m++;
				n--;
			}else if(p1 > p2){
				m++;
			}else{
				n--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,4,5,8,10};
		findPair(A);
	}
}
