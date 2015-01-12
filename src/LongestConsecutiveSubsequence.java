import java.util.ArrayList;
import java.util.*;


public class LongestConsecutiveSubsequence {
	public static ArrayList<Integer> findSequence(int[] A){
		if(A == null || A.length ==0) return new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int n : A){
			set.add(n);
		}
		int max = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < A.length; i++){
			if(!set.contains(A[i])) continue;
			ArrayList<Integer> temp = new ArrayList<>();
			int num = A[i], x = num-1, len = 1;
			set.remove(num);
			temp.add(num);
			while(set.contains(x)){
				temp.add(0, x);
				set.remove(x);
				x--;
				len++;
			}
			x = num+1;
			while(set.contains(x)){
				temp.add(x);
				set.remove(x);
				x++;
				len++;
			}
			if(len > max){
				max = len;
				list = temp;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] A = {1,6,10,4,7,9,5};
		System.out.println(findSequence(A));
	}
}
