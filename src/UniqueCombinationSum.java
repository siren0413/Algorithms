import java.util.*;

public class UniqueCombinationSum {
	public static List<List<Integer>> combinationSum(int n){
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> totalList = new ArrayList<>();
		helper(n, 1, 0, list, totalList);
		return totalList;
	}
	
	private static void helper(int n, int prev, int sum, List<Integer> list, List<List<Integer>> totalList){
		if(sum >= n){
			if(sum == n){
				totalList.add(new ArrayList<>(list));
			}
			return;
		}
		for(int i = prev; i < n; i++){
			list.add(i);
			helper(n, i, sum+i, list, totalList);
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(combinationSum(4));
	}
}
