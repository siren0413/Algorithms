import java.util.*;

public class ContinuousSubsequenceSumZero {
	public List<List<Integer>> subsequence(int[] A){
		if(A == null || A.length == 0 ) return new LinkedList<>();
		List<List<Integer>> totalList = new LinkedList<>();
		int[] sum = new int[A.length];
		sum[0] = A[0];
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0,-1);
		for(int i = 1; i < A.length; i++){
			sum[i] = sum[i-1] + A[i];
			if(!map.containsKey(sum[i])){
				map.put(sum[i],i);
			}else{
				List<Integer> list = new LinkedList<>();
				for(int k = map.get(sum[i])+1; k<=i; k++){
					list.add(A[k]);
				}
				totalList.add(list);
			}
		}
		return totalList;
	}
	
	public static void main(String[] args) {
		int[] A = {-1,-3,4,5,-2,-7};
		ContinuousSubsequenceSumZero solution = new ContinuousSubsequenceSumZero();
		System.out.println(solution.subsequence(A));
	}
}
