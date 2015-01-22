import java.util.*;


public class TwentyFourGame {
	public static boolean canWin(int[] A){
		if(A == null || A.length ==0 ) return false;
		return perm(A, 0);
	}
	
	private static boolean perm(int[] A, int i){
		if(i == A.length){
			return is24(A);
		}
		for(int k = i; k < A.length; k++){
			swap(A, i, k);
			if(perm(A, i+1)) return true;
			swap(A, i, k);
		}
		return false;
	}
	
	private static boolean is24(int[] A){
		return helper(A, 1, A[0]);
	}
	
	private static boolean helper(int[] A, int i, int result){
		if(i == A.length){
			return result == 24;
		}
		if(helper(A, i+1, result + A[i])) return true;
		if(helper(A, i+1, result - A[i])) return true;
		if(helper(A, i+1, result * A[i])) return true;
		if(helper(A, i+1, result / A[i])) return true;
		return false;
	}
	
	private static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,2,3};
		System.out.println(canWin(A));
	}
}
