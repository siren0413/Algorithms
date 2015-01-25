import java.util.*;

public class PermutationSumToNumber {
	public List<List<Integer>> sumNumber(int n){
		if(n < 1) return new LinkedList<>();
		List<List<Integer>> totalList = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		helper(n, 1, 0, list, totalList);
		return totalList;
	}
	
	private void helper(int n, int start, int sum, List<Integer> list, List<List<Integer>> totalList){
		if(sum > n){
			return;
		}
		if(sum == n){
			totalList.add(new LinkedList<>(list));
			return;
		}
		for(int k = start; k < n; k++){
			list.add(k);
			helper(n, k, sum + k, list, totalList);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		PermutationSumToNumber solution = new PermutationSumToNumber();
		System.out.println(solution.sumNumber(3));
	}
}
