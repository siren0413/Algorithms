import java.util.*;


public class RandomMaxInArray {
	public static int getMax(int[] A){
		if(A == null || A.length == 0) return -1;
		int max = A[0], cnt = 1;
		for(int i = 1; i < A.length; i++){
			if(A[i] > max){
				max = A[i];
				cnt = 1;
			}else if(A[i] == max){
				cnt++;
			}
		}
		int n = new Random().nextInt(cnt) + 1;
		for(int i = 0; i < A.length; i++){
			if(A[i] == max){
				n--;
				if(n == 0){
					return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,5,3,2,5,1,0,5,3,5};
		for(int i = 0; i < 10; i++){
			System.out.println(getMax(A));
		}
	}
}
