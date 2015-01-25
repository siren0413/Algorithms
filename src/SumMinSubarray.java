import java.util.*;

public class SumMinSubarray {
	public List<Integer> minSubarray(int[] A, int key){
		if(A == null || A.length == 0) return null;
		List<Integer> result = new LinkedList<>();
		int i = 0, j = 0, min = A.length, sum = 0, start = 0, end = 0;
		while(j < A.length){
			sum += A[j];
			if(sum >= key){
				while(i < j && sum >= key){
					if(sum - A[i] < key){
						break;
					}
					sum -= A[i];
					i++;
				}
				if(j-i<min){
					min = j-i;
					start = i;
					end = j;
				}
			}
			j++;
		}
		result.add(start);
		result.add(end);
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,1,4,6,3,2,3,7};
		SumMinSubarray solution = new SumMinSubarray();
		System.out.println(solution.minSubarray(A, 22));
		System.out.println(solution.minSubarray(A, 10));
		System.out.println(solution.minSubarray(A, 4));
	}
}
