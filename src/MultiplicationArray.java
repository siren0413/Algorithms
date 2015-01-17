import java.util.Arrays;


public class MultiplicationArray {
	public static void generateArray(int[] A, int[] B){
		if(A == null || A.length == 0){
			return;
		}
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		for(int i = 0; i < A.length; i++){
			left[i] = (i == 0? A[0]: A[i] * left[i-1]); 
		}
		for(int i = A.length-1; i>=0; i--){
			right[i] = (i==A.length-1?A[A.length-1]:A[i]*right[i+1]);
		}
		for(int i = 0; i < B.length; i++){
			B[i] = (i-1>=0? left[i-1]:1) * (i+1<=A.length-1?right[i+1]:1);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {2,1,4,3,5};
		int[] B = new int[A.length];
		generateArray(A, B);
		System.out.println(Arrays.toString(B));
	}
}
