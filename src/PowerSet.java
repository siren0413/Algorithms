import java.util.*;

public class PowerSet {
	public List<List<Integer>> powerSet(int[] A){
		if(A == null || A.length == 0) return new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		List<List<Integer>> totalList = new LinkedList<>();
		helper(A, 0, list, totalList);
		return totalList;
	}
	
	private void helper(int[] A, int i, List<Integer> list, List<List<Integer>> totalList){
		if(i == A.length){
			totalList.add(new LinkedList<>(list));
			return;
		}
		for(int k = i; k < A.length; k++){
			if(k > i && A[k-1] == A[k]){
				continue;
			}
			list.add(A[k]);
			helper(A, k+1, list, totalList);
			list.remove(list.size()-1);
		}
		helper(A, A.length, list, totalList);
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,2};
		PowerSet solution = new PowerSet();
		System.out.println(solution.powerSet(A));
	}
}
