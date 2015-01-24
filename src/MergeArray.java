import java.util.Arrays;


public class MergeArray {
	public void merge(int[] A, int[] B, int m, int n){
		int index = m + n -1;
		int i = m-1, j = n-1;
		while(i >= 0 && j >=0){
			B[index--] = A[i] > B[j]? A[i--]: B[j--];
		}
		while(i >= 0){
			B[index--] = A[i--];
		}
		while(j >= 0){
			B[index--] = B[j--];
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,5,7};
		int[] B = {2,4,6,0,0,0,0};
		MergeArray solution = new MergeArray();
		solution.merge(A, B, 4, 3);
		System.out.println(Arrays.toString(B));
	}
}
