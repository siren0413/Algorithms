import java.util.*;

public class Subsets {
	public static List<List<Integer>> subsets(int[] A){
		if(A == null || A.length == 0) return new LinkedList<>();
		List<Integer> temp = new LinkedList<>();
		List<List<Integer>> list = new LinkedList<>();
		helper(A, 0, temp, list);
		return list;
	}
	
	private static void helper(int[] A, int i, List<Integer> temp, List<List<Integer>> list){
		if(i == A.length){
			list.add(new LinkedList<Integer>(temp));
			return;
		}
		for(int k = i; k < A.length; k++){
			if(k-1 >=0 && A[k]==A[k-1]) continue;
			temp.add(A[k]);
			helper(A, k+1, temp, list);
			temp.remove(temp.size()-1);
		}
		helper(A, A.length, temp, list);
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,2};
		System.out.println(subsets(A));
	}
}
