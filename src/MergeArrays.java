import java.util.Arrays;


public class MergeArrays {
	public static void merge(int[] A, int [] B, int[] C){
		int i = 0, j = 0, k = 0;
		while(i < A.length && j < B.length){
			if(A[i] < B[j]){
				C[k] = A[i];
				i++;
			}else if (A[i] > B[j]){
				C[k] = B[j];
				j++;
			}else{
				int a = A[i];
				while(i < A.length && A[i] == a) i++;
				while(j < B.length && B[j] == a) j++;
				C[k] = a;
			}
			k++;
		}
		while(i < A.length){
			int a = A[i];
			while(i < A.length && A[i] == a) i++;
			C[k] = a;
			k++;
		}
		while(j < B.length){
			int b = B[j];
			while( j < B.length && B[j] == b) j++;
			C[k] = b;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,2,3};
		int[] B = {1,3,4};
		int[] C = new int[A.length + B.length];
		merge(A, B, C);
		System.out.println(Arrays.toString(C));
	}
}
