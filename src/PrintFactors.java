import java.util.*;

public class PrintFactors {
	public static void printFactors(int n) {
		List<Integer> list = new LinkedList<>();
		System.out.println("1 * " + n);
		helper(n, 1, list);
	}

	private static void helper(int n, int result, List<Integer> list){
		if(result == n){
			StringBuilder sb = new StringBuilder();
			for(int index = 0; index < list.size(); index++){
				if(index == list.size()-1){
					sb.append(list.get(index));
				}else{
					sb.append(list.get(index) +" * ");
				}
			}
			System.out.println(sb.toString());
			return;
		}
		int k = 2;
		if(!list.isEmpty()){
			k = list.get(list.size()-1);
		}
		while(k < n){
			if(result * k > n) return;
			list.add(k);
			helper(n, result * k, list);
			list.remove(list.size()-1);
			k++;
		}
	}
	

	public static void main(String[] args) {
		printFactors(100);
	}
}
