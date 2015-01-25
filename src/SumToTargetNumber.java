
public class SumToTargetNumber {
	public boolean isExist(int[] A, int num){
		if(A == null || A.length == 0) return false;
		return helper(A, num, 0, 0);
	}
	
	private boolean helper(int[] A, int num, int i, int prev){
		if(i == A.length){
			if(num == prev){
				return true;
			}
			return false;
		}
		if(helper(A, num, i+1, prev + A[i])) return true;
		if(helper(A, num, i+1, prev - A[i])) return true;
		if(helper(A, num, i+1, prev * A[i])) return true;
		if(helper(A, num, i+1, prev / A[i])) return true;
		if(helper(A, num, i+1, prev)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] A = {1,5,5};
		SumToTargetNumber solution = new SumToTargetNumber();
		System.out.println(solution.isExist(A, 1));
		System.out.println(solution.isExist(A, 8));
		System.out.println(solution.isExist(A, 9));
		System.out.println(solution.isExist(A, 10));
		System.out.println(solution.isExist(A, 11));
		System.out.println(solution.isExist(A, 12));
	}
}
