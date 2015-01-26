import java.util.*;

public class LongestIncreasingSubarray {
	public List<Integer> longestIncreasingSubarray(int[] A){
		int max = 0, i = 0, j = 0, prev = Integer.MIN_VALUE, start = 0;
		for(int k = start; k < A.length; k++){
			if(A[k] < prev){
				if(k - start > max){
					max = k - start;
					i = start;
					j = k;
				}
				start = k;
			}
			prev = A[k];
		}
		if(max != 0){
			List<Integer> list = new LinkedList<>();
			for(int m = i; m < j; m++){
				list.add(A[m]);
			}
			return list;
		}
		return new LinkedList<>();
	}
	
	public static void main(String[] args) {
		int[] A = {1,5,3,4,6,4};
		LongestIncreasingSubarray solution = new LongestIncreasingSubarray();
		System.out.println(solution.longestIncreasingSubarray(A));
	}
}
