import java.util.*;

public class GroupKNumbersDivisibleByNum {
	public void rearrange(int[] A, int k, int num){
		if(A == null || A.length == 0) {
			return;
		}
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i = 0; i < A.length; i++){
			int mod = A[i] % num;
			if(!map.containsKey(mod)){
				map.put(mod, new LinkedList<Integer>());
			}
			map.get(mod).add(A[i]);
		}
		List<List<Integer>> lists = new LinkedList<>();
		for(List<Integer> list: map.values()){
			lists.add(list);
		}
		int group = lists.get(0).size();
		int j = 0;
		for(int i = 0; i < group; i++){
			for(List<Integer> list: lists){
				A[j] = list.get(i);
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] A = {80,17,90,82,27,19};
		GroupKNumbersDivisibleByNum solution = new GroupKNumbersDivisibleByNum();
		solution.rearrange(A, 3, 63);
		System.out.println(Arrays.toString(A));
	}
}
