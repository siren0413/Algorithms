import java.util.Arrays;


public class MoveZeros {
	public static void moveZeros(int[] A){
		if(A == null || A.length == 0) return;
		int i = 0, j = A.length-1;
		while(i < j){
			while(i < j && A[i]!=0) i++;
			while(i < j && A[j]==0) j--;
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {3,6,0,3,0,1,2,0,8,6,0,0,3,0,5,0};
		moveZeros(A);
		System.out.println(Arrays.toString(A));
	}
}
