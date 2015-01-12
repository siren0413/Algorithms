import java.util.*;

public class FindMissingNumbers {
	public static ArrayList<Integer> findMissingNumbers(int[] A){
		if(A == null || A.length == 0) return new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int i = 1;
		while(i != A[0]){
			list.add(i);
			i++;
		}
		helper(A, 0, A.length-1,list);
		return list;
	}
	
	private static void helper(int[] A, int i, int j, ArrayList<Integer> list){
		if(i+1 == j){
			if(i+1 < A.length){
				int c = 1;
				while(A[i]+c != A[i+1]){
					list.add(A[i]+c);
					c++;
				}
			}
			return;
		}
		int mid = i + (j-i)/2;
		if(A[mid]-A[i] > mid-i){
			helper(A, i, mid, list);
		}
		if(A[j]- A[mid] > j - mid){
			helper(A, mid, j, list);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {4,5,6,8};
		System.out.println(findMissingNumbers(A));
	}
}
