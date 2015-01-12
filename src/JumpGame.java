



public class JumpGame {
	public static boolean canJump(int[] A){
		if(A == null || A.length == 0){
			return true;
		}
		int i = 0;
		while(i < A.length && A[i] != 0){
			int j = i+1, next = i + A[i];
			while(j < A.length && j < i + A[i]){
				if(j + A[j] > i + A[i]){
					next = j;
				}
				j++;
			}
			i = next;
		}
		return i >= A.length -1;
	}

	public static void main(String[] args) {
		int[] A = {5,9,3,2,1,0,2,3,3,1,0,0};
		System.out.println(canJump(A));
	}
}
