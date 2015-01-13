import java.util.*;


//Given a array of positive integers, find all possible triangle triplets that can be formed from this array. 
//eg: 9 8 10 7 
//ans: 9 8 10, 9 8 7, 9 10 7, 7 8 10 
//Note : array not sorted, there is no limit on the array length

public class FindTriangles {
	public static int findTriangles(int[] A){
		if(A == null || A.length == 0) {
			return 0;
		}
		Arrays.sort(A);
		int count = 0;
		for(int i = 0; i < A.length; i++){
			int k = i+2;
			for(int j = i+1; j < A.length-1; j++){
				while(k < A.length && A[i] + A[j] > A[k]){
					k++;
				}
				k--;
				count += k-j;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {10, 21, 22, 100, 101, 200, 300};
		System.out.println(findTriangles(A));
	}
}
