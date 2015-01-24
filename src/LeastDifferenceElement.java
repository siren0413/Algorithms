
public class LeastDifferenceElement {
	public int findElement(int[] A, int n){
		int start = 0, end = A.length-1;
		while(start + 1 < end){
			int mid = start + (end-start)/2;
			if(A[mid] == n) return mid;
			else if(A[mid] > n){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(Math.abs(A[start]-n) > Math.abs(A[end]-n)){
			return end;
		}
		return start;
	}
	
	public static void main(String[] args) {
		LeastDifferenceElement solution = new LeastDifferenceElement();
		int[] A = {1,1,2,3,6,8,9,12};
		System.out.println(solution.findElement(A, -122));
	}
}
