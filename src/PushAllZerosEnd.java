import java.util.Arrays;


public class PushAllZerosEnd {
	public void reorder(int[] A){
		int i = 0, j = A.length-1;
		while(i < j){
			while(i < j && A[i] != 0) i++;
			while(i < j && A[j] == 0) j--;
			if(i < j){
				swap(A, i, j);
			}
		}
	}
	
	private void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,0,4,0,0,8};
		PushAllZerosEnd solution = new PushAllZerosEnd();
		solution.reorder(A);
		System.out.println(Arrays.toString(A));
	}
}
